package org.uni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.uni.dao.TeachersMapper;
import org.uni.domain.Students;
import org.uni.domain.Teachers;
import org.uni.service.StudentsService;
import org.uni.dao.StudentsMapper;
import org.springframework.stereotype.Service;

/**
* @author Tao
* @description 针对表【wt_ums_students】的数据库操作Service实现
* @createDate 2022-04-18 15:24:49
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

    @Autowired
    private TeachersMapper teachersDao;

    @Override
    public boolean hasDuplicateId(String identity) {
        Teachers teacher = teachersDao.selectOne(new QueryWrapper<Teachers>().eq("wt_id10", identity));
        return teacher == null ? false : true;
    }

}




