package org.uni.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.TeaCour;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Tao
* @description 针对表【wt_ums_tea_cour】的数据库操作Mapper
* @createDate 2022-04-18 15:30:16
* @Entity org.uni.domain.TeaCour
*/
@Mapper
@Repository
public interface TeaCourMapper extends BaseMapper<TeaCour> {

}




