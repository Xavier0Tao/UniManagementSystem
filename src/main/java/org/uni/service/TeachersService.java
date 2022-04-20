package org.uni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.uni.domain.Teachers;

import java.util.List;

/**
* @author Tao
* @description 针对表【wt_ums_teachers】的数据库操作Service
* @createDate 2022-04-18 14:49:14
*/
public interface TeachersService extends IService<Teachers> {

    public boolean hasDuplicateId(String identity);

    public boolean add(Teachers teacher);

    public boolean delByTeaId(int tid);

    public boolean delById(String identity);

    public List<Teachers> getAll();

    public Teachers getOneByTeaId(int tid);

    public Teachers getById(String identity);
}
