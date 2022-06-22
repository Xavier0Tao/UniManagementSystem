use wangt_mis10;

show tables;

# 学院表信息
INSERT INTO wt_ums_college10(wt_collid10, wt_collname10) VALUES (default,'计算机学院');
INSERT INTO wt_ums_college10(wt_collid10, wt_collname10) VALUES (default,'外国语学院');
INSERT INTO wt_ums_college10(wt_collid10, wt_collname10) VALUES (default,'经济学院');
INSERT INTO wt_ums_college10(wt_collid10, wt_collname10) VALUES (default,'土木工程学院');
INSERT INTO wt_ums_college10(wt_collid10, wt_collname10) VALUES (default,'教科学院');
INSERT INTO wt_ums_college10(wt_collid10, wt_collname10) VALUES (default,'信息学院');
INSERT INTO wt_ums_college10(wt_collid10, wt_collname10) VALUES (default,'人文学院');

/*select *
from wt_ums_college;*/

# 专业表数据
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'软件工程',1);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'数字媒体',1);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'计算机科学与自动化',1);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'网络工程',1);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'计算机安全',1);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'广电',6);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'广告',6);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'播音与主持',6);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'建筑',4);
INSERT INTO wt_ums_major10(wt_mno10, wt_mname10, wt_collid10) VALUES (default,'给排水',6);

# select * from wt_ums_major;

# 班级数据...
INSERT INTO wt_ums_class10(wt_classno10, wt_mno10)
VALUES (default,1),(default,1),(default,1),(default,2),(default,2)
     ,(default,3),(default,3),(default,3),(default,4),(default,6),(default,6),(default,6)
     ,(default,6),(default,5),(default,5),(default,7),(default,7),(default,8)
     ,(default,8),(default,8),(default,9),(default,9);


# select * from wt_ums_class;

# 创建教师表
INSERT INTO wt_ums_teachers10(wt_id10, wt_name10, wt_tage10, wt_tsex10, wt_trole10,
                            wt_collid10)
 VALUES ('33023220011204','Xavier',21,'male','系统管理员',6),
        ('33023220011205','普通老师',22,'female','普通教师',1),
        ('33023220011206','校级老师',23,'male','校级管理员',4),
        ('33023220011207','院级老师',24,'female','院级管理员',1),
        ('33023220011208','tname5',25,'female','普通教师',2),
        ('33023220011209','tname6',26,'male','普通教师',6);

# select * from wt_ums_teachers;

# 课程信息
INSERT INTO wt_ums_course10(wt_cname10, wt_ccredit10, wt_chours10, wt_cform10, wt_cterm10) VALUES
('计算机组成原理',3,64,'考试',4),('编译原理',5,64,'考试',5),('SpringBoot',5,64,'考试',5),
('Java',3,64,'考试',3),('JavaEE',4,64,'考试',5),('软件测试',2,48,'考查',6),
('Vue前端框架',3,64,'考试',4),('软件质量保证',2,48,'考查',7),('美学原理',3,48,'考试',3);

# select * from wt_ums_course;

# 学生表
INSERT INTO wt_ums_students10(wt_id10, wt_sname10,
                      wt_sori10, wt_collid10, wt_mno10, wt_classno10)
VALUES ('33021220011101','VB','Toronto',1,2,7),('33021220011102','stu2','上海',6,6,14),
       ('33021220011104','stu3','宁波',6,8,22),('33021220011103','stu4','舟山',6,8,15),
       ('33021220011105','stu4','温州',4,9,16);

# 教师课程关系表
SELECT wt_tid10,wt_name10,wt_trole10,wt_ums_college10.wt_collid10,wt_collname10 FROM wt_ums_teachers10 INNER JOIN wt_ums_college10
    ON wt_ums_teachers10.wt_collid10 = wt_ums_college10.wt_collid10;

INSERT INTO wt_ums_tea_cour10(wt_tid10, wt_cno10) VALUES
(1,1),(2,3),(3,7),(4,2),(5,2),(6,4),(2,9),(3,9);

/*select *
from wt_ums_tea_cour;*/

# 学生成绩表
INSERT INTO wt_stu_score10(wt_sno10, wt_cterm10, wt_cno10, wt_score10, wt_tid10) VALUES
(1,5,5,90,2),(4,3,9,80,3);

# 临时查询
/*select wt_sno,wt_sname,wt_ums_college.wt_collid,wt_collname,wt_ums_major.wt_mname,wt_mname
from wt_ums_students
INNER JOIN wt_ums_college ON wt_ums_college.wt_collid=wt_ums_students.wt_collid
INNER JOIN wt_ums_major ON wt_ums_major.wt_mno=wt_ums_students.wt_mno;*/

select *
from wt_ums_students10;

# alter table wt_stu_score auto_increment=1;

select *
from wt_stu_score10;