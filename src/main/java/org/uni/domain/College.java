package org.uni.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @TableName wt_ums_college
 */
@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
public class College implements Serializable {
    /**
     * 学院编号
     */


    @TableId
    private Integer wtCollid;

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