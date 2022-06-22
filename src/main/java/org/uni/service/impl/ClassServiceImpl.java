package org.uni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.uni.domain.Class;
import org.uni.service.ClassService;
import org.uni.dao.ClassMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tao
 * @description 针对表【wt_ums_class10】的数据库操作Service实现
 * @createDate 2022-04-18 14:44:58
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Autowired
    private ClassMapper classDao;

    @Override
    public List<Class> getAllClass() {
        return classDao.selectList(null);
    }

    @Override
    public Class getClassById(int id) {
        return classDao.selectById(id);
    }

    @Override
    public String getClassMajorById(int id) {
        QueryWrapper<Class> wrapper = new QueryWrapper<>();
        wrapper.select("wt_mname10");
        wrapper.eq("wt_classno10", id);

        return String.valueOf(classDao.selectOne(wrapper));
    }

    @Override
    public boolean insert(Class data) {
        return classDao.insert(data) > 0;
    }

    @Override
    public boolean delById(int id) {
        return classDao.deleteById(id) > 0;
    }

}
