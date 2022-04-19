package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uni.domain.Course;
import org.uni.service.CourseService;
import org.uni.utils.dataModel.Result;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class courseController {


    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public Result getAll() {
        List<Course> list = courseService.list();

        return list == null ? new Result(false, "没有课程数据") : new Result(list);
    }

    @GetMapping("/{courseNo}")
    public Result getByCno(@PathVariable Integer courseNo) {
        Course course = courseService.getById(courseNo);
        return course == null ? new Result(false, "没有此课程") : new Result(course);
    }



}
