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
@TableName(value ="wt_ums_major10")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Major implements Serializable {
    /**
     * 专业编号
     */
    @TableId(value = "wt_mno10")
    private Integer majorNo;

    /**
     * 
     */
    @TableField("wt_mname10")
    private String majorName;

    /**
     * 关联学院编号
     */
    @TableField("wt_collid10")
    private Integer collegeId;

    public Major(String majorName, Integer collegeId) {
        this.majorName = majorName;
        this.collegeId = collegeId;
    }

    public Major(String majorName) {
        this.majorName = majorName;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}