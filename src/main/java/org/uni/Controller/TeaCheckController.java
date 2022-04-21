package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uni.domain.TeaCheck;
import org.uni.service.TeaCheckService;
import org.uni.utils.dataModel.Result;

import java.util.List;

@RestController
@RequestMapping("/teaCheck")
public class TeaCheckController {

    @Autowired
    private TeaCheckService teaCheckService;

    @GetMapping
    public Result getAll() {
        List<TeaCheck> list = teaCheckService.list();
        return list.size() == 0 ? new Result(false, "没有教师打卡记录") : new Result(list);
    }


}
