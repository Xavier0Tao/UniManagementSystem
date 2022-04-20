package org.uni.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 
 * @TableName wt_ums_students
 */
@TableName(value ="wt_ums_students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Students implements Serializable {
    /**
     * 学生编号
     */
    @TableId(value = "wt_sno", type = IdType.AUTO)
    private int sno;

    /**
     * 身份证
     */
    @TableField(value = "wt_id")
    private String id;

    /**
     * 学生姓名
     */
    @TableField(value = "wt_sname")
    private String sname;

    /**
     * 性别
     */
    @TableField(value = "wt_sex")
    private String sex;

    /**
     * 年龄
     */
    @TableField(value = "wt_sage")
    private Integer sage;

    /**
     * 生源地
     */
    @TableField(value = "wt_sori")
    private String sori;

    /**
     * 总学分
     */
    @TableField(value = "wt_scredits")
    private Integer scredits;

    /**
     * 所属学院编号
     */
    @TableField(value = "wt_collid")
    private Integer collid;

    /**
     * 所属专业编号
     */
    @TableField(value = "wt_mno")
    private Integer mno;

    /**
     * 所属班级编号
     */
    @TableField(value = "wt_classno")
    private Integer classno;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}