package org.uni.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.Students;
import org.uni.service.StudentsService;
import org.uni.utils.dataModel.Result;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StuController {

    @Autowired
    private StudentsService studentsService;

    /**
     * 注册学生用户
     *
     * @param student
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

    @GetMapping("/{sno}")
    public Result getById(@PathVariable("sno") int sno) {
        return new Result(studentsService.getById(sno));
    }

    @GetMapping
    public Result conditionalQuery(@RequestParam(required = false, name = "homeTown") String homeTown,
                                   @RequestParam(name = "collegeId", required = false) Integer collegeId,
                                   @RequestParam(name = "majorNo", required = false) Integer majorNo,
                                   @RequestParam(name = "sex", required = false) String sex) {
        QueryWrapper<Students> wrapper = new QueryWrapper<>();
        wrapper.eq(homeTown != null, "wt_sori", homeTown)
                .eq(collegeId != null, "wt_collid", collegeId)
                .eq(majorNo != null, "wt_mno", majorNo)
                .eq(sex != null, "wt_sex", sex);

        List<Students> list = studentsService.list(wrapper);

        return list == null ? new Result(false, "没有满足条件的学生") : new Result(list);
    }

}
