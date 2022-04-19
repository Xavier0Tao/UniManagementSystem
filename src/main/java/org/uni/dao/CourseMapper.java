package org.uni.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.Course;

/**
* @author Tao
* @description 针对表【wt_ums_course】的数据库操作Mapper
* @createDate 2022-04-18 15:10:37
* @Entity org.uni.domain.Course
*/
@Mapper
@Repository
public interface CourseMapper extends BaseMapper<Course> {


}
