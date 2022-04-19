package org.uni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.uni.domain.Major;
import org.uni.service.MajorService;
import org.uni.dao.MajorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tao
 * @description 针对表【wt_ums_major】的数据库操作Service实现
 * @createDate 2022-04-18 14:40:23
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
        implements MajorService {
    @Autowired
    private MajorMapper majorDao;

    @Override
    public List<Major> getAllMajor() {
        return majorDao.selectList(null);
    }

    @Override
    public Major getOneMajorById(int id) {
        return majorDao.selectById(id);
    }

    @Override
    public List<Major> getMajorByName(String name) {
        QueryWrapper<Major> wrapper = new QueryWrapper<>();
        wrapper.eq("wt_mname", name);
        return majorDao.selectList(wrapper);
    }

    @Override
    public boolean insertOne(Major major) {
        return majorDao.insert(major) > 0;
    }

    @Override
    public boolean insertList(List<Major> majorList) {
        boolean flag = false;

        for (Major major : majorList) {
            if (flag == false)
                flag = majorDao.insert(major) > 0;
        }
        return flag;
    }

    @Override
    public boolean delById(int id) {
        return majorDao.deleteById(id) > 0;
    }


}
