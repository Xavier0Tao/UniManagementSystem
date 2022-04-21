package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uni.domain.StuCheck;
import org.uni.service.StuCheckService;
import org.uni.utils.dataModel.Result;

import java.util.List;

@RestController
@RequestMapping("/stuCheck")
public class StuCheckController {
    @Autowired
    private StuCheckService stuCheckService;

    @GetMapping
    public Result getAll() {
        List<StuCheck> list = stuCheckService.list();
        return list.size() == 0 ? new Result(false, "没有学生打卡记录") : new Result(list);
    }


}
