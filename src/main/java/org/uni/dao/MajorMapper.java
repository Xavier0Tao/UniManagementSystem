package org.uni.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.uni.domain.Major;

/**
* @author Tao
* @description 针对表【wt_ums_major】的数据库操作Mapper
* @createDate 2022-04-18 14:40:23
* @Entity org.uni.domain.Major
*/
@Mapper
@Repository("majorDao")
public interface MajorMapper extends BaseMapper<Major> {


}
