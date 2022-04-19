package org.uni.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.TeaHealthcode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Tao
* @description 针对表【wt_ums_tea_healthcode】的数据库操作Mapper
* @createDate 2022-04-18 15:32:44
* @Entity org.uni.domain.TeaHealthcode
*/
@Mapper
@Repository
public interface TeaHealthcodeMapper extends BaseMapper<TeaHealthcode> {

}




