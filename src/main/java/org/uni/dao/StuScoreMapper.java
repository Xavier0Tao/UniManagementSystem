package org.uni.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.uni.domain.StuScore;
import org.uni.dto.CourseAvgDto;

import java.util.List;

/**
 * @author Tao
 * @description 针对表【wt_stu_score】的数据库操作Mapper
 * @createDate 2022-04-18 15:15:28
 * @Entity org.uni.domain.WtStuScore
 */
@Mapper
@Repository
public interface StuScoreMapper extends BaseMapper<StuScore> {

    @Select("select s.wt_cno AS courseNo,avg(s.wt_score) AS avg,c.wt_cname As courseName" +
            " from wangt_mis.wt_stu_score AS s" +
            " inner join wangt_mis.wt_ums_course AS c on s.wt_cno = c.wt_cno " +
            " group by s.wt_cno;")
    public List<CourseAvgDto> getCourseAvg();

}




