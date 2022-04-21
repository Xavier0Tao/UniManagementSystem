package org.uni.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.StuScore;
import org.uni.service.WtStuScoreService;
import org.uni.utils.dataModel.Result;

@RestController
@RequestMapping("/stuScore")
public class WtStuScoreController {
    @Autowired
    private WtStuScoreService stuScoreService;

    @GetMapping("/{stuNo}/{courseNo}")
    public Result getOne(@PathVariable Integer stuNo,
                         @PathVariable Integer courseNo) {
        QueryWrapper<StuScore> wrapper = new QueryWrapper<>();
        wrapper.eq("wt_sno", stuNo);
        wrapper.eq("wt_cno", courseNo);

        StuScore stuScore = stuScoreService.getOne(wrapper);
        return stuScore == null ? new Result(false, "没有相关信息") : new Result(stuScore);
    }

    @PostMapping
    public Result add(@RequestBody StuScore stuScore) {
        return new Result(stuScoreService.save(stuScore));
    }

    @DeleteMapping("/{stuNo}/{courseNo}")
    public Result del(@PathVariable Integer stuNo,
                      @PathVariable Integer courseNo){
        QueryWrapper<StuScore> wrapper = new QueryWrapper<>();
        wrapper.eq("wt_sno", stuNo);
        wrapper.eq("wt_cno", courseNo);

        return new Result(stuScoreService.remove(wrapper));
    }


}
