package org.uni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uni.dao.StudentsMapper;
import org.uni.dao.TeaHealthcodeMapper;
import org.uni.dao.TeachersMapper;
import org.uni.dao.stuHealthcodeMapper;
import org.uni.domain.StuHealthcode;
import org.uni.domain.Students;
import org.uni.domain.TeaHealthcode;
import org.uni.domain.Teachers;
import org.uni.service.HealthcodeService;
import org.uni.utils.dataModel.healthCondition;

import javax.print.DocFlavor;

/**
* @author Tao
* @description 针对表【wt_ums_stu_healthcode】的数据库操作Service实现
* @createDate 2022-04-18 15:22:09
*/
@Service
public class HealthcodeServiceImpl extends ServiceImpl<stuHealthcodeMapper, StuHealthcode>  implements HealthcodeService{


    @Autowired
    private StudentsMapper studentsDao;

    @Autowired
    private TeachersMapper teachersDao;

    @Autowired
    private stuHealthcodeMapper stuHealthcodeDao;

    @Autowired
    private TeaHealthcodeMapper teaHealthcodeDao;

    /**
     * 通过condition判断健康码颜色
     */
    @Override
    public String judgeCode(healthCondition condition) {
        if (condition.isBeenArea() || condition.isBeenArea() || condition.isUnhealthy()) {
            return "YELLOW";
        } else if (condition.isClose() || condition.isConfirmed() || condition.isSeriousUnheathy()) {
            return "RED";
        }
        return "GREEN";
    }


    /**
     * 通过身份证设置健康码颜色
     */
    @Override
    public boolean setCode(String identity, String color) {
        Students obj = studentsDao.selectOne(new QueryWrapper<Students>().eq("wt_id", identity));
        int stu_id = obj == null ? 0 : (int) obj.getSno();

        Teachers teacher = teachersDao.selectOne(new QueryWrapper<Teachers>().eq("wt_id", identity));
        int teacherId = teacher == null ? 0 : (int) teacher.getTeacherId();

        if (stu_id != 0) {
            StuHealthcode stucode = new StuHealthcode(stu_id,color);
//            return stuHealthcodeDao.update(stucode, new QueryWrapper<StuHealthcode>().eq("wt_sid", stu_id)) > 0;
            return stuHealthcodeDao.updateById(stucode) > 0;
        } else if (teacherId != 0) {
            TeaHealthcode teacode = new TeaHealthcode(teacherId, color);
            return teaHealthcodeDao.updateById(teacode) > 0 ;
//            return teaHealthcodeDao.update(teacode, new QueryWrapper<TeaHealthcode>().eq("wt_tid", teacherId)) > 0;
        }

        return false;
    }

    /**
     * 通过学号和名字获取健康码颜色
     */
    @Override
    public StuHealthcode queryCodeStu(int sno, String name) {
        Students student = studentsDao.selectOne(new QueryWrapper<Students>().eq("wt_sno", sno));
        //有这个学生
        if (student != null) {
            //名字也对的上
            if (student.getSname().equals(name)) {
                //获取他的健康码
                StuHealthcode stuHealthcode = stuHealthcodeDao.selectById(sno);
                return stuHealthcode;
            } else return null;
        }
        return null;
    }


}




