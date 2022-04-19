package org.uni.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.Teachers;

/**
* @author Tao
* @description 针对表【wt_ums_teachers】的数据库操作Mapper
* @createDate 2022-04-18 14:49:14
* @Entity org.uni.domain.Teachers
*/
@Mapper
@Repository
public interface TeachersMapper extends BaseMapper<Teachers> {
}
