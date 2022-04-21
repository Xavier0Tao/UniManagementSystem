package org.uni.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 
 * @TableName wt_ums_major
 */
@TableName(value ="wt_ums_major")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Major implements Serializable {
    /**
     * 专业编号
     */
    @TableId(value = "wt_mno")
    private Integer majorNo;

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

    public Major(String majorName, Integer collegeId) {
        this.majorName = majorName;
        this.collegeId = collegeId;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}