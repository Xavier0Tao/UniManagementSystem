package org.uni.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.uni.domain.Class;
import org.uni.service.ClassService;
import org.uni.dao.ClassMapper;
import org.springframework.stereotype.Service;

/**
* @author Tao
* @description 针对表【wt_ums_class】的数据库操作Service实现
* @createDate 2022-04-18 14:44:58
*/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService{

}
