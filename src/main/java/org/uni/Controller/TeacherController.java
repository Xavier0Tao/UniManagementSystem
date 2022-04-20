package org.uni.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.Teachers;
import org.uni.service.TeachersService;
import org.uni.utils.dataModel.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeachersService teachersService;

    /**
     * 教师注册
     *
     * @return
     */
    @PostMapping("/register")
    /**
     * "collegeId": 0,
     *   "id": "string",
     *   "name": "string",
     *   "tage": 0,
     *   "teacherId": 0,
     *   "tphone": "string",
     *   "trole": "string",
     *   "tsex": "string",
     *   "tstatus": "string"
     */
    public Result register(@RequestParam(name = "name") String teacherName,
                           @RequestParam(name = "id") String identity,
                           @RequestParam(name = "trole") String trole,
                           @RequestParam(name = "tsex") String sex,
                           @RequestParam(name = "collegeId", required = false) Integer collegeId) {
        Teachers teacher = new Teachers();
        teacher.setName(teacherName);
        teacher.setId(identity);
        teacher.setTrole(trole);
        teacher.setTsex(sex);
        teacher.setCollegeId(collegeId);

        boolean isDulplicateId = teachersService.hasDuplicateId(teacher.getId());

        if (isDulplicateId) return new Result(!isDulplicateId, "重复身份证号码");
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
     * 通过教师编号删除教师
     * @param teacherId
     */
    @DeleteMapping("/{tid}")
    public Result delByTeacherId(@PathVariable("tid") int teacherId) {

        return new Result(teachersService.removeById(teacherId));
    }

    @GetMapping("/getAll")
    public Result getAllTeachers() {
        List<Teachers> list = teachersService.list();
        return list == null ? new Result(false, "没有教师信息") : new Result(list);
    }

    @PostMapping("/login")
    public Result login(@RequestParam(value = "identity", required = false) String identity,
                        @RequestParam(name = "teacherId", required = false) Integer teacherId, HttpServletRequest request) {

        QueryWrapper<Teachers> wrapper = new QueryWrapper<>();
        wrapper.eq(identity != null, "wt_id", identity)
                .eq(teacherId != null, "wt_tid", teacherId);

        Teachers teacher = teachersService.getOne(wrapper);

        HttpSession session = request.getSession();

        //如果登录成功就把信息存入
        if (teacher != null) {
            session.setAttribute("ROLE", "T_" + teacher.getTrole());
            session.setAttribute("ROLEINFO", teacher);
        }

        return teacher == null ? new Result(false, "没有此教师信息") : new Result(teacher);
    }

    @GetMapping
    public Result conditionalQuery(@RequestParam(name = "teacherId", required = false) Integer teacherId,
                                   @RequestParam(name = "identity", required = false) String identity,
                                   @RequestParam(name = "teacherName", required = false) String teacherName,
                                   @RequestParam(name = "teacherRole", required = false) String teacherRole,
                                   @RequestParam(name = "collegeId", required = false) Integer collegeId) {
        QueryWrapper<Teachers> wrapper = new QueryWrapper<>();
        wrapper.eq(teacherId != null, "wt_tid", teacherId)
                .eq(identity != null, "wt_id", identity)
                .eq(teacherName != null, "wt_name", teacherName)
                .eq(teacherRole != null, "wt_trole", teacherRole)
                .eq(collegeId != null, "wt_collid", collegeId);

        List<Teachers> teachers = teachersService.list(wrapper);

        return teachers.size() == 0 ? new Result(false, "没有教师信息") : new Result(teachers);
    }
}
