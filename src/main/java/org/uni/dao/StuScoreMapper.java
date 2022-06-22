package org.uni.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.uni.domain.StuScore;
import org.uni.dto.CourseAvgDto;
import org.uni.dto.StuCourseDto;

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

    @Select("select s.wt_cno10 AS courseNo,avg(s.wt_score10) AS avg,c.wt_cname10 As courseName" +
            " from wangt_mis10.wt_stu_score10 AS s" +
            " inner join wangt_mis10.wt_ums_course10 AS c on s.wt_cno10 = c.wt_cno10 " +
            " group by s.wt_cno10;")
    public List<CourseAvgDto> getCourseAvg();

    @Select("select s.wt_sno10 AS stuName,stu.wt_sname10 AS stuName,c.wt_cno10 AS courseNo,c.wt_cname10 AS courseName,c.wt_ccredit10 AS courseCredit" +
            " from wangt_mis10.wt_stu_score10 AS s" +
            " inner join wangt_mis10.wt_ums_course10 AS c ON s.wt_cno10 = c.wt_cno10  " +
            "inner join wangt_mis10.wt_ums_students10 AS stu on s.wt_sno10=stu.wt_sno10 " +
            "where s.wt_sno10 =#{stuNo}")
    public List<StuCourseDto> getStuCourse(Integer stuNo);

}




