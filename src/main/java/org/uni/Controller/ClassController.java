package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.Class;
import org.uni.domain.Course;
import org.uni.service.ClassService;
import org.uni.dto.Result;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/{classId}")
    public Result getOne(@PathVariable Integer classId) {
        Class byId = classService.getById(classId);
        return byId == null ? new Result(false, "没有此班级信息") : new Result(byId);
    }

    @GetMapping
    public Result getAll() {
        List<Class> list = classService.list();

        return list.size() == 0 ? new Result(false, "没有班级信息") : new Result(list);
    }

    @DeleteMapping("/{id}")
    public Result delById(@PathVariable Integer id) {
        return new Result(classService.removeById(id));
    }

    @PostMapping
    public Result add(@RequestBody Class item) {
        return new Result(classService.save(item));
    }

    @GetMapping("/courses")
    public Result getCourses() {
        Map<Class, List<Course>> courses = classService.getCourses();
        if (courses == null || courses.isEmpty()) return Result.fail();
        return Result.ok(courses);
    }

}
