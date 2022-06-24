package org.uni.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.StuScore;
import org.uni.dto.CourseAvgDto;
import org.uni.dto.StuCourseDto;
import org.uni.service.WtStuScoreService;
import org.uni.dto.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/stuScore")
public class StuScoreController {
    @Resource
    private WtStuScoreService stuScoreService;

    @GetMapping("/{stuNo}/{courseNo}")
    public Result getOne(@PathVariable(name = "stuNo") Integer stuNo,
                         @PathVariable(name = "courseNo") Integer courseNo) {
        QueryWrapper<StuScore> wrapper = new QueryWrapper<>();
        wrapper.eq("wt_sno10", stuNo);
        wrapper.eq("wt_cno10", courseNo);

        StuScore stuScore = stuScoreService.getOne(wrapper);
        return stuScore == null ? new Result(false, "没有相关信息") : new Result(stuScore);
    }

    /**
     * 查询统计学生分数
     *
     */
    @GetMapping
    public Result getScore(@RequestParam(name = "stuNo", required = false) Integer stuNo
            , @RequestParam(name = "order", required = false) Boolean order
            , @RequestParam(name = "academicYear",required = false) Integer academicYear,
                           HttpServletRequest request) {

        System.out.println(academicYear);

        //条件
        QueryWrapper<StuScore> wrapper = new QueryWrapper<>();

        //可选，根据学生学号查询
        wrapper.eq(stuNo != null, "wt_sno10", stuNo);

        //可选，根据学年查询
        if (academicYear != null) {
            wrapper.eq("wt_cterm10", academicYear * 2 - 1)
                    .or().eq("wt_cterm10", academicYear * 2);
        }

        // 查询
        List<StuScore> list = stuScoreService.list(wrapper);

        //结果判空,如果结果为空直接返回
        if (list == null || list.isEmpty()) return Result.fail();

        //设置学年字段，因为学年字段是数据库表外部的字段
        for (StuScore stuScore : list) {
            Integer term = stuScore.getCterm();
            if ( term != null) stuScore.setAcademicYear((term + 1) / 2);
        }

        //查询结果非空且需要排序
        if (order != null && order) {
            //排序
            list.sort((o1, o2) -> {
                        BigDecimal diff = o1.getScore().subtract(o2.getScore());
                        //返回compare的结果
                        return o1.getScore().compareTo(o2.getScore());
                    }
            );
        }

        request.setAttribute("stuScore", list);

        return Result.ok(list);
    }

    @PostMapping
    public Result add(@RequestBody StuScore stuScore) {
        return new Result(stuScoreService.save(stuScore));
    }

    @DeleteMapping("/{stuNo}/{courseNo}")
    public Result del(@PathVariable Integer stuNo,
                      @PathVariable Integer courseNo) {
        QueryWrapper<StuScore> wrapper = new QueryWrapper<>();
        wrapper.eq("wt_sno10", stuNo);
        wrapper.eq("wt_cno10", courseNo);

        return new Result(stuScoreService.remove(wrapper));
    }

    @GetMapping("/courseAvg")
    public Result getCourseAvg() {
        List<CourseAvgDto> courseAvgs = stuScoreService.getCourseAvg();
        if (courseAvgs == null || courseAvgs.isEmpty()) return Result.fail();
        return Result.ok(courseAvgs);
    }

    /**
     * 查询学生所学课程及学分统计
     *
     * @param stuNo 学号
     */
    @GetMapping("/stuCourse")
    public Result getStuCourse(@RequestParam(name = "stuNo", required = false) Integer stuNo) {

        List<StuCourseDto> stuCourses = stuScoreService.getStuCourse(stuNo);

        //判空
        if (stuCourses == null || stuCourses.isEmpty()) return Result.fail();

        return Result.ok(stuCourses);
    }

}
