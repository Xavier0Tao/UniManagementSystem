package org.uni.domain;




import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 
 * @TableName wt_ums_course
 */
@TableName(value ="wt_ums_course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Course implements Serializable {
    /**
     * 课程编号
     */
    @TableId("wt_cno")
    private Integer courseNo;

    /**
     * 课程名称
     */
    @TableField("wt_cname")
    private String courseName;

    /**
     * 课程学分
     */
    @TableField("wt_ccredit")
    private Integer courseCredit;

    /**
     * 课程学时
     */
    @TableField("wt_chours")
    private Integer courseHours;

    /**
     * 形式
     */
    @TableField("wt_cform")
    private String courseForm;

    /**
     * 开设学期
     */
    @TableField("wt_cterm")
    private Integer courseTerm;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}