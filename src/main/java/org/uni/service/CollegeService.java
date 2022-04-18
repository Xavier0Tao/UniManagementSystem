package org.uni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.uni.domain.College;

import java.util.List;

/**
* @author Tao
* @description 针对表【wt_ums_college】的数据库操作Service
* @createDate 2022-04-18 12:49:18
*/
public interface CollegeService {
    boolean add(College college);

    List<College> queryByName(String name);

}