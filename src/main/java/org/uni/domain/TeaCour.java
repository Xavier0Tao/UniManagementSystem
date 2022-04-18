package org.uni.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 
 * @TableName wt_ums_tea_cour
 */
@TableName(value ="wt_ums_tea_cour")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TeaCour implements Serializable {
    /**
     * 教师编号
     */
    @TableField(value = "wt_tid")
    private Integer tid;

    /**
     * 课程编号
     */
    @TableField(value = "wt_cno")
    private Integer cno;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}