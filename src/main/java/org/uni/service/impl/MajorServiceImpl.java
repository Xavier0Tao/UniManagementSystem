package org.uni.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.uni.domain.Major;
import org.uni.service.MajorService;
import org.uni.dao.MajorMapper;
import org.springframework.stereotype.Service;

/**
* @author Tao
* @description 针对表【wt_ums_major】的数据库操作Service实现
* @createDate 2022-04-18 14:40:23
*/
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
implements MajorService{

}
