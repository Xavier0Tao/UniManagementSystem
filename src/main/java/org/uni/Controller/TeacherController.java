package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.Teachers;
import org.uni.service.TeachersService;
import org.uni.utils.dataModel.Result;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeachersService teachersService;

    /**
     * 教师注册
     * @param teacher
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Teachers teacher) {

        boolean isDulplicateId = teachersService.hasDuplicateId(teacher.getId());

        if (isDulplicateId) return new Result(!isDulplicateId,"重复身份证号码");
        return new Result(teachersService.save(teacher));
    }

    /**
     * 通过教师编号获取教师
     * @param tid
     * @return
     */
    @GetMapping("/{tid}")
    public Result getByTeacherId(@PathVariable int tid) {
        Teachers teacher = teachersService.getById(tid);

        return teacher == null ? new Result(false, "查无此教师") : new Result(teacher);
    }

    /**
     * 通过身份证获取教师
     */
    @GetMapping
    public Result getByIdentity(@RequestParam("identity") String identity) {
        Teachers teacher = teachersService.getById(identity);

        return teacher == null ? new Result(false, "查无此教师") : new Result(teacher);
    }

    /**
     * 通过教师编号删除教师
     * @param teacherId
     */
    @DeleteMapping("/{tid}")
    public Result delByTeacherId(@PathVariable("tid") int teacherId) {

        return new Result(teachersService.removeById(teacherId));
    }

}
