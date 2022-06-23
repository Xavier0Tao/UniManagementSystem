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
@TableName(value ="wt_ums_course10")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Course implements Serializable {
    /**
     * 课程编号
     */
    @TableId("wt_cno10")
    private Integer courseNo;

    /**
     * 课程名称
     */
    @TableField("wt_cname10")
    private String courseName;

    /**
     * 课程学分
     */
    @TableField("wt_ccredit10")
    private Integer courseCredit;

    /**
     * 课程学时
     */
    @TableField("wt_chours10")
    private Integer courseHours;

    /**
     * 形式
     */
    @TableField("wt_cform10")
    private String courseForm;

    /**
     * 开设学期
     */
    @TableField("wt_cterm10")
    private Integer courseTerm;

    @TableField("wt_classno10")
    private Integer classNo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}