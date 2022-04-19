package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.StuHealthcode;
import org.uni.service.HealthcodeService;
import org.uni.utils.dataModel.Result;
import org.uni.utils.dataModel.healthCondition;

@RestController
@RequestMapping("/healthCodes")
public class healthCodeController {

    @Autowired
    private HealthcodeService healthcodeService;


    /**
     * 提交表单信息 获取健康码
     * @param condition
     * @param identity
     * @return
     */
    @PostMapping("/submit")
    public Result getHealethCode(@RequestBody healthCondition condition, @RequestParam(value = "identity", required = true) String identity) {

        Result result = new Result((Object) healthcodeService.judgeCode(condition));

        String color = (String) result.getData();
        healthcodeService.setCode(identity, color);

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

    //通过身份证查询健康码
    @GetMapping("/colorByIdentity")
    public Result query(@RequestParam("identity") String identity) {

        return null;
    }


}
