package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.Course;
import org.uni.service.CourseService;
import org.uni.dto.Result;

import java.util.List;


@RestController
@RequestMapping("/courses")
public class courseController {


    @Autowired
    private CourseService courseService;

    @GetMapping
    public Result getAll() {
        List<Course> list = courseService.list();

        return list == null ? new Result(false, "没有课程数据") : new Result(list);
    }

    @GetMapping("/{courseNo}")
    public Result getByCno(@PathVariable Integer courseNo) {
        Course course = courseService.getById(courseNo);
        return course == null ? new Result(false, "没有此课程") : new Result(course);
    }

    @PostMapping
    public Result add(@RequestBody Course course) {
        return new Result(courseService.save(course));
    }

    @DeleteMapping("/{courseNo}")
    public Result delById(@PathVariable Integer courseNo) {
        return new Result(courseService.removeById(courseNo));
    }


}
