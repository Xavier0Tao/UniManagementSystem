package org.uni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.uni.dao.StudentsMapper;
import org.uni.domain.Students;
import org.uni.domain.Teachers;
import org.uni.service.TeachersService;
import org.uni.dao.TeachersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tao
* @description 针对表【wt_ums_teachers】的数据库操作Service实现
* @createDate 2022-04-18 14:49:14
*/
@Service
public class TeachersServiceImpl extends ServiceImpl<TeachersMapper, Teachers>
implements TeachersService{

    @Autowired
    private TeachersMapper teaDao;

    @Autowired
    private StudentsMapper studentsDao;

    /**
     * 查找是否有重复的身份证
     * @param identity
     */
    @Override
    public boolean hasDuplicateId(String identity) {
        Students stu = studentsDao.selectOne(new QueryWrapper<Students>().eq("wt_id", identity));

        if(stu == null) return false;
        else return true;
    }

    @Override
    public boolean add(Teachers teacher) {
        return teaDao.insert(teacher) > 0;
    }

    @Override
    public boolean delByTeaId(int tid) {
        return teaDao.deleteById(tid) > 0;
    }

    @Override
    public boolean delById(String identity) {
        return teaDao.delete(new QueryWrapper<Teachers>().eq("wt_id", identity)) > 0;
    }

    @Override
    public List<Teachers> getAll() {
        return teaDao.selectList(null);
    }

    @Override
    public Teachers getOneByTeaId(int tid) {
        return teaDao.selectById(tid);
    }

    @Override
    public Teachers getById(String identity) {
        return teaDao.selectOne(new QueryWrapper<Teachers>().eq("wt_id", identity));
    }


}
