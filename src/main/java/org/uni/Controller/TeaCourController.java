package org.uni.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.TeaCour;
import org.uni.service.TeaCourService;
import org.uni.utils.dataModel.Result;

import java.util.List;

@RestController
@RequestMapping("/teaCour")
public class TeaCourController {
    @Autowired
    private TeaCourService teaCourService;

    @GetMapping
    public Result getAll() {
        List<TeaCour> list = teaCourService.list();
        return list.size() == 0 ? new Result(false, "没有相关信息") : new Result(list);
    }

    @PostMapping
    public Result add(@RequestParam(name = "teacherId") Integer teacherId, @RequestParam(name = "courseNo") Integer courseNo) {
        return new Result(teaCourService.save(new TeaCour(teacherId, courseNo)));
    }

    @DeleteMapping("/{teacherId}/{courseNo}")
    public Result del(@PathVariable Integer teacherId, @PathVariable Integer courseNo) {
        QueryWrapper<TeaCour> wrapper = new QueryWrapper<>();
        wrapper.eq("wt_tid", teacherId);
        wrapper.eq("wt_cno", courseNo);

        return new Result(teaCourService.remove(wrapper));
    }

}
