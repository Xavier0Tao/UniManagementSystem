use wangt_mis;

# 输入成绩时自动给学生的总学分更新
CREATE TRIGGER auto_update_scredits
    AFTER INSERT  ON wt_stu_score  FOR EACH ROW
    BEGIN
        IF (new.wt_score >= 60 ) THEN
            UPDATE wt_ums_students
            SET wt_ums_students.wt_scredits = wt_scredits
                + (SELECT wt_ccredit FROM wt_ums_course WHERE wt_ums_course.wt_cno = new.wt_cno)
            WHERE wt_ums_students.wt_sno = new.wt_sno;
end if;
    end;

# 设置教师和学生时自动为他们在健康码表中设置记录
CREATE TRIGGER auto_add_stu_healthcode
    AFTER INSERT ON wt_ums_students FOR EACH ROW
    BEGIN
        /*IF (new.wt_sno NOT IN (SELECT wt_sno from wt_ums_students)) THEN
            INSERT INTO wt_ums_stu_healthcode (wt_sid, wt_code_color) VALUES (new.wt_sno, 'red');
        end if;*/
        INSERT INTO wt_ums_stu_healthcode (wt_sid, wt_code_color) VALUES (new.wt_sno, 'red');
    end;

CREATE TRIGGER auto_add_tea_healthcode
    AFTER INSERT ON wt_ums_teachers FOR EACH ROW
BEGIN
    INSERT INTO wt_ums_tea_healthcode (wt_tid, wt_code_color) VALUES (new.wt_tid,'red');
end;

# 教师和学生打卡之后自动更新健康码
CREATE TRIGGER auto_fill_stu_healthcode
    AFTER INSERT ON wt_ums_stu_check FOR EACH ROW
BEGIN
    IF((SELECT COUNT(wt_records) FROM wt_ums_stu_check WHERE wt_sid = new.wt_sid) >= 7) THEN
        UPDATE wt_ums_stu_healthcode SET wt_code_color ='Green' WHERE wt_sid=new.wt_sid;
    end if;
end;

CREATE TRIGGER auto_fill_tea_healthcode
    AFTER INSERT ON wt_ums_tea_check FOR EACH ROW
BEGIN
    IF((SELECT COUNT(wt_records) FROM wt_ums_tea_check WHERE wt_tid = new.wt_tid) >= 7) THEN
        UPDATE wt_ums_tea_healthcode SET wt_code_color ='Green' WHERE wt_tid=new.wt_tid;
    end if;
end;

show triggers ;