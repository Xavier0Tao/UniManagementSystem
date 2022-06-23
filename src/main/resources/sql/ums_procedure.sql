DELIMITER //
CREATE PROCEDURE getStuCourse(in stuNo INT)
BEGIN
    select s.wt_sno10     AS stuName,
           stu.wt_sname10 AS stuName,
           c.wt_cno10     AS courseNo,
           c.wt_cname10   AS courseName,
           c.wt_ccredit10 AS courseCredit
    from wangt_mis10.wt_stu_score10 AS s
             inner join wangt_mis10.wt_ums_course10 AS c ON s.wt_cno10 = c.wt_cno10
             inner join wangt_mis10.wt_ums_students10 AS stu on s.wt_sno10 = stu.wt_sno10
    where s.wt_sno10 = stuNo;
end//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getCourseAvg()
BEGIN
    select s.wt_cno10 AS courseNo
         , avg(s.wt_score10) AS avg
         , c.wt_cname10 As courseName
    from wangt_mis10.wt_stu_score10 AS s
             inner join wangt_mis10.wt_ums_course10 AS c
                 on s.wt_cno10 = c.wt_cno10
    group by s.wt_cno10;
end //
DELIMITER ;