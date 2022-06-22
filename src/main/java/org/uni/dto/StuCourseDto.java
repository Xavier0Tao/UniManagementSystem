package org.uni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuCourseDto {
    /**
     * 学号
     */
    private Integer stuNo;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 课程编号
     */
    private Integer courseNo;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程学分
     */
    private Integer courseCredit;

}
