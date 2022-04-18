package org.uni.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.uni.domain.Course;
import org.uni.service.CourseService;
import org.uni.dao.CourseMapper;
import org.springframework.stereotype.Service;

/**
* @author Tao
* @description 针对表【wt_ums_course】的数据库操作Service实现
* @createDate 2022-04-18 15:10:37
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
implements CourseService{

}
