package org.uni.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.uni.domain.StuHealthcode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Tao
* @description 针对表【wt_ums_stu_healthcode】的数据库操作Mapper
* @createDate 2022-04-18 15:22:09
* @Entity org.uni.domain.StuHealthcode
*/
@Mapper
@Repository
public interface stuHealthcodeMapper extends BaseMapper<StuHealthcode> {

    @Update("update wangt_mis.wt_ums_stu_healthcode set wt_code_color = #{color} where wt_sid=#{id}")
    public int update(@Param("color") String color,@Param("id") Integer id);

}




