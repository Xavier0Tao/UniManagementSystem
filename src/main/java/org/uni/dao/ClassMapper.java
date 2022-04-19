package org.uni.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.Class;

/**
* @author Tao
* @description 针对表【wt_ums_class】的数据库操作Mapper
* @createDate 2022-04-18 14:44:58
* @Entity org.uni.domain.Class
*/
@Mapper
@Repository
public interface ClassMapper extends BaseMapper<Class> {


}
