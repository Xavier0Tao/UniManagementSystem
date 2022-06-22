package org.uni.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.uni.domain.StuScore;
import org.uni.dto.CourseAvgDto;
import org.uni.dto.StuCourseDto;
import org.uni.service.WtStuScoreService;
import org.uni.dao.StuScoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Tao
* @description 针对表【wt_stu_score】的数据库操作Service实现
* @createDate 2022-04-18 15:15:28
*/
@Service
public class WtStuScoreServiceImpl extends ServiceImpl<StuScoreMapper, StuScore>
    implements WtStuScoreService{

    @Resource
    private StuScoreMapper stuScoreMapper;

    @Override
    public List<CourseAvgDto> getCourseAvg() {
        return stuScoreMapper.getCourseAvg();
    }

    @Override
    public List<StuCourseDto> getStuCourse(Integer stuNo) {
        return stuScoreMapper.getStuCourse(stuNo);
    }

}




