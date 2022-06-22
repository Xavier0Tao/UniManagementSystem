package org.uni.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.*;

/**
 * 
 * @TableName wt_stu_score
 */
@TableName(value ="wt_stu_score10")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class StuScore implements Serializable {
    /**
     * 学号
     */
    @MppMultiId
    @TableField("wt_sno10")
    private Integer sno;

    /**
     * 课程编号
     */
    @MppMultiId
    @TableField("wt_cno10")
    private Integer cno;

    /**
     * 学期
     */
    @TableField(value = "wt_cterm10")
    private Integer cterm;

    @TableField(exist = false)
    private Integer academicYear;

    /**
     * 成绩
     */
    @TableField(value = "wt_score10")
    private BigDecimal score;

    /**
     * 教师编号
     */
    @TableField(value = "wt_tid10")
    private Integer tid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}