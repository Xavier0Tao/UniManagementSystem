package org.uni.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Repository;

/**
 * @TableName wt_ums_college
 */
@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class College implements Serializable {
    /**
     * 学院编号
     */


    @TableId(value = "wt_collid")
    private Integer collegeId;

    /**
     *
     */
    @TableField("wt_collname")
    private String collegeName;

    private static final long serialVersionUID = 1L;

    public College(String name) {
        this.collegeName = name;
    }

}