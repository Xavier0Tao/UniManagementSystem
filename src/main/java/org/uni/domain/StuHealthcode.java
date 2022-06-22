package org.uni.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 
 * @TableName wt_ums_stu_healthcode
 */
@TableName(value ="wt_ums_stu_healthcode10")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class StuHealthcode implements Serializable {
    /**
     * 学生编号
     */
    @TableId(value = "wt_sid10")
    private int sid;

    /**
     * 码颜色
     */
    @TableField(value = "wt_code_color10")
    private String codeColor;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}