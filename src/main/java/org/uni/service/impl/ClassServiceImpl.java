package org.uni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.uni.domain.Class;
import org.uni.domain.Course;
import org.uni.service.ClassService;
import org.uni.dao.ClassMapper;
import org.springframework.stereotype.Service;
import org.uni.dao.CourseMapper;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 * @description 针对表【wt_ums_class10】的数据库操作Service实现
 * @createDate 2022-04-18 14:44:58
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Resource
    private ClassMapper classDao;

    @Resource
    private CourseMapper courseMapper;

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

    @Override
    public Map<Class, List<Course>> getCourses() {
        //获取所有课程
        List<Class> allClasses = getAllClass();

        //根据课程数量初始化Map大小，避免多次重哈希操作
        Map<Class, List<Course>> resultMap = new HashMap<>(allClasses.size());

        for (Class aClass : allClasses) {
            //获得班级编号
            Integer classNo = aClass.getClassNo();

            //根据班级编号在课程表中查找 对应班级编号的课程
            List<Course> courseList = courseMapper.selectList(new QueryWrapper<Course>().eq("wt_classno10", classNo));

            resultMap.put(aClass, courseList);
        }

        return resultMap;
    }

}
