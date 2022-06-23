use mysql;

#Can not find table primary key in Class: "org.uni.domain.StuCheck".
/*Can not find table primary key in Class: "org.uni.domain.StuHealthcode".
Can not find table primary key in Class: "org.uni.domain.TeaCheck".
Can not find table primary key in Class: "org.uni.domain.TeaCour".
Can not find table primary key in Class: "org.uni.domain.TeaHealthcode".
Can not find table primary key in Class: "org.uni.domain.StuScore".*/

# 创建数据库
CREATE DATABASE wangt_mis10 default charset utf8mb4;

#用该数据库
use wangt_mis10;


# ******************+  建表的顺序不能动 **********************************

#创建学院表
CREATE TABLE wt_ums_college10(
    wt_collid10 INT PRIMARY KEY AUTO_INCREMENT COMMENT '学院编号',
    wt_collname10 VARCHAR(20) NOT NULL DEFAULT '默认学院名称'
)ENGINE =InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_college10 ADD CONSTRAINT UNIQUE (wt_collname10);

# 创建专业表
CREATE TABLE wt_ums_major10(
    wt_mno10 INT PRIMARY KEY AUTO_INCREMENT COMMENT '专业编号',
    wt_mname10 VARCHAR(22) NOT NULL DEFAULT '默认专业名',
    wt_collid10 INT COMMENT '关联学院编号',
    FOREIGN KEY (wt_collid10) REFERENCES wt_ums_college10(wt_collid10) ON DELETE CASCADE ,
    CONSTRAINT uk_mname UNIQUE (wt_mname10)
)ENGINE = InnoDB,charset =utf8mb4;

# 创建班级表
CREATE TABLE wt_ums_class10(
    wt_classno10 int primary key auto_increment COMMENT '班级编号',
    wt_mno10 INT COMMENT '外键关联专业编号',
    wt_mname10 VARCHAR(22) COMMENT '反范式化',
    FOREIGN KEY fk_mno (wt_mno10) REFERENCES wt_ums_major10(wt_mno10) ON DELETE CASCADE
)ENGINE =InnoDB ,charset =utf8mb4;


# 创建教师表
CREATE TABLE wt_ums_teachers10
(
    wt_tid10   INT PRIMARY KEY AUTO_INCREMENT COMMENT '教师编号',
    wt_id10    VARCHAR(30)  COMMENT '教师身份证',
    wt_name10  VARCHAR(20)  DEFAULT 'default name' COMMENT '教师姓名',
    wt_tage10  INT COMMENT '教师年龄',
    wt_tsex10  VARCHAR(6) CHECK ( wt_tsex10 = 'male' OR wt_tsex10 = 'female' OR wt_tsex10 = '男' OR wt_tsex10 = '女') COMMENT '性别',
    wt_trole10 varchar(10) CHECK ( wt_trole10 = '系统管理员' OR wt_trole10 = '校级管理员' OR wt_trole10 = '院级管理员' OR
                                 wt_trole10 = '普通教师' ) not null default '普通教师' comment '教师角色',
    wt_tstatus10 VARCHAR(20) NOT NULL DEFAULT '讲师' COMMENT '教师职位，与角色区别',
    wt_tphone10 VARCHAR(15) COMMENT '电话号码',
    wt_collid10 INT COMMENT '学院编号',
    CONSTRAINT FOREIGN KEY (wt_collid10) REFERENCES wt_ums_college10(wt_collid10) ON DELETE SET NULL,
    CONSTRAINT uk_id UNIQUE (wt_id10)
)ENGINE = InnoDB,charset =utf8mb4;

# 创建课程表
CREATE TABLE wt_ums_course10(
    wt_cno10 INT AUTO_INCREMENT COMMENT '课程编号',
    wt_cname10 VARCHAR(22) COMMENT '课程名称' ,
    wt_ccredit10 INT COMMENT '课程学分',
    wt_chours10 INT COMMENT '课程学时',
    wt_cform10 VARCHAR(2) CHECK ( wt_cform10 ='考试' OR wt_cform10='考查' ) COMMENT '形式',
    wt_cterm10 INT CHECK ( wt_cterm10 < 9  AND wt_cterm10 > 0) COMMENT '开设学期',
    wt_classno10 INT DEFAULT NULL,
    FOREIGN KEY fk_class (wt_classno10) REFERENCES wt_ums_class10(wt_classno10),
    INDEX idx_cname (wt_cname10) COMMENT '方便通过课程名称查看课程的其他信息',
    PRIMARY KEY pk_cno (wt_cno10)
)ENGINE =InnoDB,charset =utf8mb4;

# 学生表
# | 学号 | 身份证 | 姓名 | 性别 | 年龄 | 生源 | 已修总学分 | 学院编号（FK） | 专业编号（FK） | 班级编号（FK） | id   |
CREATE TABLE wt_ums_students10(
    wt_sno10 INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学生编号',
    wt_id10 VARCHAR(30) NOT NULL COMMENT '身份证',
    wt_sname10 VARCHAR(22) COMMENT '学生姓名',
    wt_sex10 VARCHAR(6) CHECK ( wt_sex10= 'male'OR wt_sex10='female' OR wt_sex10='男' OR wt_sex10='女' ) COMMENT '性别',
    wt_sage10 INT CHECK ( wt_sage10 >0 AND wt_sage10<120)COMMENT '年龄' ,
    wt_sori10 VARCHAR(30) COMMENT '生源地',
    wt_scredits10 INT DEFAULT 0 COMMENT '总学分',
    wt_collid10 INT COMMENT '所属学院编号',
    wt_mno10 INT COMMENT '所属专业编号',
    wt_classno10 INT COMMENT '所属班级编号',
    PRIMARY KEY pk_sno (wt_sno10) COMMENT '主键',
    CONSTRAINT FOREIGN KEY fk_collid (wt_collid10) REFERENCES wt_ums_college10(wt_collid10) ON DELETE SET NULL ,
    CONSTRAINT FOREIGN KEY fk_mno (wt_mno10) REFERENCES  wt_ums_major10(wt_mno10) ON DELETE SET NULL ,
    CONSTRAINT FOREIGN KEY fk_classno (wt_classno10) REFERENCES wt_ums_class10(wt_classno10) ON DELETE SET NULL
)ENGINE =InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_students10 ADD UNIQUE (wt_id10);

# 学生健康码
CREATE TABLE wt_ums_stu_healthcode10(
    wt_sid10 INT UNSIGNED COMMENT '学生学号',
    wt_code_color10 VARCHAR(7) COMMENT '码颜色',
    CONSTRAINT FOREIGN KEY fk_sid (wt_sid10) REFERENCES wt_ums_students10(wt_sno10) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_stu_healthcode10 ADD PRIMARY KEY (wt_sid10);


# 教师健康码
CREATE TABLE wt_ums_tea_healthcode10(
    wt_tid10 INT COMMENT '教师编号',
    wt_code_color10 VARCHAR(7) COMMENT '颜色',
    CONSTRAINT FOREIGN KEY fk_tid (wt_tid10) REFERENCES wt_ums_teachers10(wt_tid10) ON DELETE CASCADE
)ENGINE = InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_tea_healthcode10 ADD PRIMARY KEY (wt_tid10);

# 教师打卡表
CREATE TABLE wt_ums_tea_check10(
    wt_tid10 INT COMMENT '教师编号',
    wt_records10 TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '打卡记录',
    CONSTRAINT FOREIGN KEY fk_tid (wt_tid10) REFERENCES wt_ums_teachers10(wt_tid10) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;

# 学生打卡表
CREATE TABLE wt_ums_stu_check10(
    wt_sid10 INT UNSIGNED COMMENT '学生编号',
    wt_records10 TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '打卡记录',
    CONSTRAINT FOREIGN KEY fk_sid (wt_sid10) REFERENCES wt_ums_students10(wt_sno10) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;

# 教师课程表
CREATE TABLE wt_ums_tea_cour10(
    wt_tid10 INT COMMENT '教师编号',
    wt_cno10 INT COMMENT '课程编号',
    FOREIGN KEY fk_tid(wt_tid10) REFERENCES wt_ums_teachers10(wt_tid10) ON DELETE CASCADE ,
    FOREIGN KEY fk_cno (wt_cno10) REFERENCES wt_ums_course10(wt_cno10) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;

# 学生成绩表
# 学号PK(FK) 学期 课程编号PK(FK) 成绩 教师编号FK
CREATE TABLE wt_stu_score10(
    wt_sno10 INT UNSIGNED COMMENT '学号',
    wt_cterm10 INT COMMENT '学期',
    wt_cno10 INT COMMENT '课程编号',
    wt_score10 DECIMAL(3,1) COMMENT '成绩',
    wt_tid10 INT COMMENT '教师编号',
    PRIMARY KEY (wt_sno10,wt_cno10) ,
    FOREIGN KEY fk_sno (wt_sno10) REFERENCES wt_ums_students10(wt_sno10) ON DELETE CASCADE ,
    FOREIGN KEY fk_cno(wt_cno10) REFERENCES wt_ums_course10(wt_cno10) ON DELETE CASCADE ,
    FOREIGN KEY fk_tid(wt_tid10) REFERENCES wt_ums_teachers10(wt_tid10) ON DELETE SET NULL
)ENGINE =InnoDB,charset =utf8mb4;




