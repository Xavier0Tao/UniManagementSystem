package org.uni.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * 
 * @TableName wt_ums_tea_check
 */
@TableName(value ="wt_ums_tea_check10")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TeaCheck implements Serializable {
    /**
     * 教师编号
     */
    @TableField(value = "wt_tid10")
    private Integer tid;

    /**
     * 打卡记录
     */
    @TableField(value = "wt_records10")
    private Date records;

    public TeaCheck(Integer tid) {
        this.tid = tid;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}