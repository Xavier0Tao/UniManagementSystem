package org.uni.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.uni.domain.Teachers;
import org.uni.service.TeachersService;
import org.uni.dao.TeachersMapper;
import org.springframework.stereotype.Service;

/**
* @author Tao
* @description 针对表【wt_ums_teachers】的数据库操作Service实现
* @createDate 2022-04-18 14:49:14
*/
@Service
public class TeachersServiceImpl extends ServiceImpl<TeachersMapper, Teachers>
implements TeachersService{

}
