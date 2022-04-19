package org.uni.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.TeaCheck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Tao
* @description 针对表【wt_ums_tea_check】的数据库操作Mapper
* @createDate 2022-04-18 15:28:11
* @Entity org.uni.domain.TeaCheck
*/
@Mapper
@Repository
public interface TeaCheckMapper extends BaseMapper<TeaCheck> {

}




