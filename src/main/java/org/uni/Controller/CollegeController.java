package org.uni.Controller;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.College;
import org.uni.service.CollegeService;
import org.uni.utils.dataModel.Result;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        College college = collegeService.getById(id);
        return college == null ? new Result(false, "没有此学院") : new Result(college);
    }

    @GetMapping
    public Result getAll() {
        List<College> list = collegeService.list();
        return list.size() == 0 ? new Result(false, "没有学院信息") : new Result(list);
    }

    @PostMapping
    public Result add(@RequestParam(name = "collegeName", required = true) String collegeName) {
        return new Result(collegeService.save(new College(collegeName)));
    }

    @DeleteMapping("/{collegeId}")
    public Result delById(@PathVariable Integer collegeId) {
        return new Result(collegeService.removeById(collegeId));
    }

}
