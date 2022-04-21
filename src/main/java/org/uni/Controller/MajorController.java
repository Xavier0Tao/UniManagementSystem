package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uni.domain.Major;
import org.uni.service.MajorService;
import org.uni.utils.dataModel.Result;

import java.util.List;

@RestController
@RequestMapping("/majors")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/{majorNo}")
    public Result getByNo(@PathVariable Integer majorNo) {
        Major major = majorService.getById(majorNo);
        return major == null ? new Result(false, "没有此专业") : new Result(major);
    }

    @GetMapping
    public Result getAll() {
        List<Major> list = majorService.list();

        return list.size() == 0 ? new Result(false, "没有专业信息") : new Result(list);
    }

    @PostMapping
    public Result add(@RequestParam(name = "majorName", required = true) String majorName,
                      @RequestParam(name = "collegeId", required = false) Integer collegeId) {
        return new Result(majorService.save(new Major( majorName, collegeId)));
    }

    @DeleteMapping("/{majorNo}")
    public Result delById(@PathVariable Integer majorNo) {
        return new Result(majorService.removeById(majorNo));
    }

}
