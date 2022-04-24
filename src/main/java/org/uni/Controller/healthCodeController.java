package org.uni.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.StuHealthcode;
import org.uni.domain.TeaHealthcode;
import org.uni.domain.Teachers;
import org.uni.service.HealthcodeService;
import org.uni.service.TeaHealthcodeService;
import org.uni.utils.dataModel.Result;
import org.uni.utils.dataModel.healthCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/healthCodes")
public class healthCodeController {

    @Autowired
    private HealthcodeService healthcodeService;

    @Autowired
    private TeaHealthcodeService teaHealthcodeService;

    @Autowired
    private HealthCheckController healthCheckController;

    /**
     * 提交表单信息 获取健康码 设置健康码 并且新增打卡记录
     *
     * @param condition
     * @param identity
     * @return
     */
    @PostMapping("/submit/{identity}")
    public Result getHealethCode(@RequestBody healthCondition condition, @PathVariable String identity, HttpServletRequest request) throws ClassNotFoundException {

        Result result = new Result((Object) healthcodeService.judgeCode(condition));

        String color = (String) result.getData();

        // 设置健康码颜色..
        healthcodeService.setCode(identity, color);

        // 新增打卡记录
        healthCheckController.check(request);

        return result;
    }

    //学号请求健康码
    @GetMapping("/colorBySno")
    public Result query(@RequestParam("sno") int sno, @RequestParam("name") String name) {
        Result result = new Result();

        StuHealthcode stuHealthcode = healthcodeService.queryCodeStu(sno, name);

        if (stuHealthcode != null) {
            result.setCode(1);
            result.setMsg("查询成功");
            result.setData(stuHealthcode.getCodeColor());
        } else {
            result.setCode(0);
            result.setMsg("查询不到");
        }

        return result;
    }

    //教师编号查询健康码
    @GetMapping("/colorByTeachId")
    public Result query(@RequestParam("teacherId") String teacherId) {
        TeaHealthcode teaHealthcode = teaHealthcodeService.getOne(new QueryWrapper<TeaHealthcode>().eq("wt_tid", teacherId));

        return teaHealthcode == null ? new Result(false, "无此教师的健康码信息") : new Result(teaHealthcode);
    }

    @GetMapping("/students")
    public Result getAllStu() {
        List<StuHealthcode> list = healthcodeService.list();
        return list.size() == 0 ? new Result(false, "没有学生健康码信息") : new Result(list);
    }

    @GetMapping("/teachers")
    public Result getAllTeachers() {
        List<TeaHealthcode> list = teaHealthcodeService.list();
        return list.size() == 0 ? new Result(false, "没有教师健康码信息") : new Result(list);
    }

}
