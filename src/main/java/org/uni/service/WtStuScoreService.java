package org.uni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.uni.domain.StuScore;
import org.uni.dto.CourseAvgDto;

import java.util.List;

/**
* @author Tao
* @description 针对表【wt_stu_score】的数据库操作Service
* @createDate 2022-04-18 15:15:28
*/
public interface WtStuScoreService extends IService<StuScore> {
    List<CourseAvgDto> getCourseAvg();
}
