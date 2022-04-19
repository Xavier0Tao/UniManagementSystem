package org.uni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.uni.domain.Class;

import java.util.List;

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
}
