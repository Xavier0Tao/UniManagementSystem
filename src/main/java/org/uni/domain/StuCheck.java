package org.uni.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.models.auth.In;
import lombok.*;

/**
 * @TableName wt_ums_stu_check
 */
@TableName(value = "wt_ums_stu_check10")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class StuCheck implements Serializable {

    /**
     * 学生编号
     */
    @TableField(value = "wt_sid10")
    private Integer sid;

    /**
     * 打卡记录
     */
    @TableField(value = "wt_records10")
    private Date records;

    public StuCheck(Integer sid) {
        this.sid = sid;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}