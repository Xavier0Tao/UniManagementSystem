package org.uni.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.Students;
import org.uni.service.StudentsService;
import org.uni.utils.dataModel.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StuController {

    @Autowired
    private StudentsService studentsService;

    /**
     * 注册学生用户
     *
     * @param
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Students student) {

        boolean hasDuplicateId = studentsService.hasDuplicateId(student.getId());

        if (hasDuplicateId) return new Result(!hasDuplicateId, "重复身份证号码");
        return new Result(studentsService.save(student));
    }

    @DeleteMapping("/del/{sno}")
    public Result delBySno(@PathVariable("sno") int sno) {
        return new Result(studentsService.removeById(sno));
    }

    @GetMapping("/getAll")
    public Result getAll() {
        return new Result(studentsService.list());
    }

    @GetMapping("/{stuNo}")
    public Result getById(@PathVariable Integer stuNo) {
        return new Result(studentsService.getById(stuNo));
    }

    @GetMapping
    public Result conditionalQuery(@RequestParam(required = false, name = "homeTown") String homeTown,
                                   @RequestParam(name = "collegeId", required = false) Integer collegeId,
                                   @RequestParam(name = "majorNo", required = false) Integer majorNo,
                                   @RequestParam(name = "sex", required = false) String sex,
                                   @RequestParam(name = "studentNo", required = false) Integer studentNo) {

        QueryWrapper<Students> wrapper = new QueryWrapper<>();
        wrapper.eq(homeTown != null, "wt_sori", homeTown)
                .eq(collegeId != null, "wt_collid", collegeId)
                .eq(majorNo != null, "wt_mno", majorNo)
                .eq(sex != null, "wt_sex", sex)
                .eq(studentNo != null, "wt_sno", studentNo);

        List<Students> list = studentsService.list(wrapper);

        return list.size() == 0 ? new Result(false, "没有满足条件的学生") : new Result(list);
    }

    /**
     * 通过学号或身份证登录学生账号
     * @param sno
     * @param identity
     */
    @PostMapping("/login")
    public Result login(@RequestParam(name = "studentNo",required = false) Integer sno
            , @RequestParam(name = "identity", required = false) String identity, HttpServletRequest request) {

        //查询条件
        QueryWrapper<Students> wrapper = new QueryWrapper<>();
        wrapper.eq(sno != null, "wt_sno", sno)
                .eq(identity != null, "wt_id", identity);

        Students stu = studentsService.getOne(wrapper);
        HttpSession session = request.getSession();

        //在login之后把信息加入session中
        if (stu != null) {
            session.setAttribute("ROLE", "STU");
            session.setAttribute("ROLEINFO", stu);
        }

        return stu == null ? new Result(false, "没有此学生信息") : new Result(stu);
    }


}
