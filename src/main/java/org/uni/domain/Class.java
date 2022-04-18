package org.uni.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 
 * @TableName wt_ums_class
 */
@TableName(value ="wt_ums_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Class implements Serializable {
    /**
     * 班级编号
     */
    @TableId(value = "wt_classno")
    private Integer classNo;

    /**
     * 外键关联专业编号
     */
    @TableField("wt_mno")
    private Integer majorNo;

    /**
     * 反范式化
     */
    @TableField("wt_mname")
    private String majorName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}