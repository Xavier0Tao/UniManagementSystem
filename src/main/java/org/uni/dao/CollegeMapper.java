package org.uni.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.College;

/**
* @author Tao
* @description 针对表【wt_ums_college】的数据库操作Mapper
* @createDate 2022-04-18 12:49:18
* @Entity org.uni.domain.College
*/
@Mapper
@Repository("collegeDao")
public interface CollegeMapper extends BaseMapper<College> {

}
