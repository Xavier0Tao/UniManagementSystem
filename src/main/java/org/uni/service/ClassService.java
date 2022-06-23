package org.uni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSourceExtensionsKt;
import org.uni.domain.Class;

import java.util.List;
import java.util.Map;

import org.uni.domain.Course;

/**
* @author Tao
* @description 针对表【wt_ums_class】的数据库操作Service
* @createDate 2022-04-18 14:44:58
*/
public interface ClassService extends IService<Class> {
    public List<Class> getAllClass();

    public Class getClassById(int id);

    public String getClassMajorById(int id);

    public boolean insert(Class data);

    public boolean delById(int id);

    public Map<Class, List<Course>> getCourses();
}
