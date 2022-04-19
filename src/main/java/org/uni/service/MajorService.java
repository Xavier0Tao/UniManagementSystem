package org.uni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.uni.domain.Major;

import java.util.List;

/**
* @author Tao
* @description 针对表【wt_ums_major】的数据库操作Service
* @createDate 2022-04-18 14:40:23
*/

public interface MajorService extends IService<Major> {
    public List<Major> getAllMajor();

    public Major getOneMajorById(int id);

    public List<Major> getMajorByName(String name);

    public boolean insertOne(Major major);

    public boolean insertList(List<Major> majorList);

    public boolean delById(int id);


}
