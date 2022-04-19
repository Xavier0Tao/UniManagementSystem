package org.uni.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.StuScore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Tao
* @description 针对表【wt_stu_score】的数据库操作Mapper
* @createDate 2022-04-18 15:15:28
* @Entity org.uni.domain.WtStuScore
*/
@Mapper
@Repository
public interface StuScoreMapper extends BaseMapper<StuScore> {

}




