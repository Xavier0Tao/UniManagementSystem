use wangt_mis10;

# 输入成绩时自动给学生的总学分更新
CREATE TRIGGER auto_update_scredits
    AFTER INSERT  ON wt_stu_score10  FOR EACH ROW
    BEGIN
        IF (new.wt_score10 >= 60 ) THEN
            UPDATE wt_ums_students10
            SET wt_ums_students10.wt_scredits10 = wt_scredits10
                + (SELECT wt_ccredit10 FROM wt_ums_course10 WHERE wt_ums_course10.wt_cno10 = new.wt_cno10)
            WHERE wt_ums_students10.wt_sno10 = new.wt_sno10;
end if;
    end;



# 设置教师和学生时自动为他们在健康码表中设置记录
CREATE TRIGGER auto_add_stu_healthcode
    AFTER INSERT ON wt_ums_students10 FOR EACH ROW
    BEGIN
        /*IF (new.wt_sno NOT IN (SELECT wt_sno from wt_ums_students)) THEN
            INSERT INTO wt_ums_stu_healthcode (wt_sid, wt_code_color) VALUES (new.wt_sno, 'red');
        end if;*/
        INSERT INTO wt_ums_stu_healthcode10 (wt_sid10, wt_code_color10) VALUES (new.wt_sno10, 'RED');
    end;

CREATE TRIGGER auto_add_tea_healthcode
    AFTER INSERT ON wt_ums_teachers10 FOR EACH ROW
BEGIN
    INSERT INTO wt_ums_tea_healthcode10 (wt_tid10, wt_code_color10) VALUES (new.wt_tid10,'RED');
end;

# 教师和学生打卡之后自动更新健康码
CREATE TRIGGER auto_fill_stu_healthcode
    AFTER INSERT ON wt_ums_stu_check10 FOR EACH ROW
BEGIN
    IF((SELECT COUNT(wt_records10) FROM wt_ums_stu_check10 WHERE wt_sid10 = new.wt_sid10) >= 7) THEN
        UPDATE wt_ums_stu_healthcode10 SET wt_code_color10 ='GREEN' WHERE wt_sid10=new.wt_sid10;
    end if;
end;

CREATE TRIGGER auto_fill_tea_healthcode
    AFTER INSERT ON wt_ums_tea_check10 FOR EACH ROW
BEGIN
    IF((SELECT COUNT(wt_records10) FROM wt_ums_tea_check10 WHERE wt_tid10 = new.wt_tid10) >= 7) THEN
        UPDATE wt_ums_tea_healthcode10 SET wt_code_color10 ='GREEN' WHERE wt_tid10=new.wt_tid10;
    end if;
end;
