package org.uni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.uni.domain.College;
import org.uni.service.CollegeService;
import org.uni.dao.CollegeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tao
* @description 针对表【wt_ums_college】的数据库操作Service实现
* @createDate 2022-04-18 12:49:18
*/
@Service
public class CollegeServiceImpl implements CollegeService{

    @Autowired
    @Qualifier("collegeDao")
    private CollegeMapper mapper;

    @Override
    public boolean add(College college) {
        return mapper.insert(college) > 0;
    }

    @Override
    public List<College> queryByName(String name) {

        return null;
    }


}
