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
@TableName(value ="wt_stu_score")
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
    @TableField("wt_sno")
    private Object sno;

    /**
     * 课程编号
     */
    @MppMultiId
    @TableField("wt_cno")
    private Integer cno;

    /**
     * 学期
     */
    @TableField(value = "wt_cterm")
    private Integer cterm;

    /**
     * 成绩
     */
    @TableField(value = "wt_score")
    private BigDecimal score;

    /**
     * 教师编号
     */
    @TableField(value = "wt_tid")
    private Integer tid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}