package org.uni.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 
 * @TableName wt_ums_teachers
 */
@TableName(value ="wt_ums_teachers10")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Teachers implements Serializable {
    /**
     * 教师编号
     */
    @TableId("wt_tid10")
    private Integer teacherId;

    /**
     * 教师身份证
     */
    @TableField("wt_id10")
    private String id;

    /**
     * 教师姓名
     */
    @TableField("wt_name10")
    private String name;

    /**
     * 教师年龄
     */
    @TableField("wt_tage10")
    private Integer tage;

    /**
     * 性别
     */
    @TableField("wt_tsex10")
    private String tsex;

    /**
     * 教师角色
     */
    @TableField("wt_trole10")
    private String trole;

    /**
     * 教师职位，与角色区别
     */
    @TableField("wt_tstatus10")
    private String tstatus;

    /**
     * 电话号码
     */
    @TableField("wt_tphone10")
    private String tphone;

    /**
     * 学院编号
     */
    @TableField("wt_collid10")
    private Integer collegeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}