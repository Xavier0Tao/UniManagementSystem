package org.uni.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName wt_ums_teachers
 */
@TableName(value ="wt_ums_teachers")
@Data
public class Teachers implements Serializable {
    /**
     * 教师编号
     */
    @TableId
    private Integer tid;

    /**
     * 教师身份证
     */
    private String id;

    /**
     * 教师姓名
     */
    private String name;

    /**
     * 教师年龄
     */
    private Integer tage;

    /**
     * 性别
     */
    private String tsex;

    /**
     * 教师角色
     */
    private String trole;

    /**
     * 教师职位，与角色区别
     */
    private String tstatus;

    /**
     * 电话号码
     */
    private String tphone;

    /**
     * 学院编号
     */
    private Integer collid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}