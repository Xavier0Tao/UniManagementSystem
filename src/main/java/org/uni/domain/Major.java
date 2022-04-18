package org.uni.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName wt_ums_major
 */
@TableName(value ="wt_ums_major")
@Data
public class Major implements Serializable {
    /**
     * 专业编号
     */
    @TableId
    private Integer wtMno;

    /**
     * 
     */
    @TableField("wt_mname")
    private String majorName;

    /**
     * 关联学院编号
     */
    @TableField("wt_collid")
    private Integer collegeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}