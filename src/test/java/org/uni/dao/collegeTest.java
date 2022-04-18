package org.uni.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.uni.domain.College;

import java.util.List;

@SpringBootTest
public class collegeTest {

    @Autowired
    private CollegeMapper collegeMapper;

    @Test
    public void test1() {
        List<College> colleges = collegeMapper.selectList(null);
        for (College college : colleges) {
            System.out.println(college);
        }
    }

    @Test
    public void selectOne() {
        College college = collegeMapper.selectById(3);

    }

    @Test
    public void selectAll() {

        QueryWrapper<College> wrapper = new QueryWrapper<>();

        collegeMapper.selectList(null);
    }

    @Test
    public void add() {
        collegeMapper.insert(new College("化工学院"));
    }

    @Test
    public void del() {
        QueryWrapper<College> wrapper = new QueryWrapper<>();

        wrapper.eq("wt_collname", "计算机学院");
        collegeMapper.delete(wrapper);
    }

    @Test
    public void ge() {
        QueryWrapper<College> wrapper = new QueryWrapper<>();
        String column = "wt_collid";
        wrapper.ge(1 < 2, column, 2);
        collegeMapper.selectList(wrapper);
    }

    @Test
    public void conditionalSearch() {
        QueryWrapper<College> wrapper = new QueryWrapper<>();
        wrapper.eq("wt_collname", "管理学院");
        QueryWrapper<College> wrapper1 = new QueryWrapper<>();

        wrapper1.eq(collegeMapper.selectCount(wrapper) < 2, "wt_collname", "管理学院");

        wrapper1.ge(1 < 2, "wt_collid", 3);

        collegeMapper.selectList(wrapper1);
    }



}
