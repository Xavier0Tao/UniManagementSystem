use mysql;

#Can not find table primary key in Class: "org.uni.domain.StuCheck".
/*Can not find table primary key in Class: "org.uni.domain.StuHealthcode".
Can not find table primary key in Class: "org.uni.domain.TeaCheck".
Can not find table primary key in Class: "org.uni.domain.TeaCour".
Can not find table primary key in Class: "org.uni.domain.TeaHealthcode".
Can not find table primary key in Class: "org.uni.domain.StuScore".*/

# 创建数据库
CREATE DATABASE wangt_mis default charset utf8mb4;

#用该数据库
use wangt_mis;


# ******************+  建表的顺序不能动 **********************************

#创建学院表
CREATE TABLE wt_ums_college(
    wt_collid INT PRIMARY KEY AUTO_INCREMENT COMMENT '学院编号',
    wt_collname VARCHAR(20) NOT NULL DEFAULT '默认学院名称'
)ENGINE =InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_college ADD CONSTRAINT UNIQUE (wt_collname);

# 创建专业表
CREATE TABLE wt_ums_major(
    wt_mno INT PRIMARY KEY AUTO_INCREMENT COMMENT '专业编号',
    wt_mname VARCHAR(22) NOT NULL DEFAULT '默认专业名',
    wt_collid INT COMMENT '关联学院编号',
    FOREIGN KEY (wt_collid) REFERENCES wt_ums_college(wt_collid) ON DELETE CASCADE ,
    CONSTRAINT uk_mname UNIQUE (wt_mname)
)ENGINE = InnoDB,charset =utf8mb4;

# 创建班级表
CREATE TABLE wt_ums_class(
    wt_classno int primary key auto_increment COMMENT '班级编号',
    wt_mno INT COMMENT '外键关联专业编号',
    wt_mname VARCHAR(22) COMMENT '反范式化',
    FOREIGN KEY fk_mno (wt_mno) REFERENCES wt_ums_major(wt_mno) ON DELETE CASCADE
)ENGINE =InnoDB ,charset =utf8mb4;


# 创建教师表
CREATE TABLE wt_ums_teachers
(
    wt_tid   INT PRIMARY KEY AUTO_INCREMENT COMMENT '教师编号',
    wt_id    VARCHAR(30)  COMMENT '教师身份证',
    wt_name  VARCHAR(20)  DEFAULT 'default name' COMMENT '教师姓名',
    wt_tage  INT COMMENT '教师年龄',
    wt_tsex  VARCHAR(6) CHECK ( wt_tsex = 'male' OR wt_tsex = 'female' OR wt_tsex = '男' OR wt_tsex = '女') COMMENT '性别',
    wt_trole varchar(10) CHECK ( wt_trole = '系统管理员' OR wt_trole = '校级管理员' OR wt_trole = '院级管理员' OR
                                 wt_trole = '普通教师' ) not null default '普通教师' comment '教师角色',
    wt_tstatus VARCHAR(20) NOT NULL DEFAULT '讲师' COMMENT '教师职位，与角色区别',
    wt_tphone VARCHAR(15) COMMENT '电话号码',
    wt_collid INT COMMENT '学院编号',
    CONSTRAINT FOREIGN KEY (wt_collid) REFERENCES wt_ums_college(wt_collid) ON DELETE SET NULL,
    CONSTRAINT uk_id UNIQUE (wt_id)
)ENGINE = InnoDB,charset =utf8mb4;

# 创建课程表
CREATE TABLE wt_ums_course(
    wt_cno INT AUTO_INCREMENT COMMENT '课程编号',
    wt_cname VARCHAR(22) COMMENT '课程名称' ,
    wt_ccredit INT COMMENT '课程学分',
    wt_chours INT COMMENT '课程学时',
    wt_cform VARCHAR(2) CHECK ( wt_cform ='考试' OR wt_cform='考查' ) COMMENT '形式',
    wt_cterm INT CHECK ( wt_cterm < 9  AND wt_cterm > 0) COMMENT '开设学期',
    INDEX idx_cname (wt_cname) COMMENT '方便通过课程名称查看课程的其他信息',
    PRIMARY KEY pk_cno (wt_cno)
)ENGINE =InnoDB,charset =utf8mb4;

# 学生表
# | 学号 | 身份证 | 姓名 | 性别 | 年龄 | 生源 | 已修总学分 | 学院编号（FK） | 专业编号（FK） | 班级编号（FK） | id   |
CREATE TABLE wt_ums_students(
    wt_sno INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学生编号',
    wt_id VARCHAR(30) NOT NULL COMMENT '身份证',
    wt_sname VARCHAR(22) COMMENT '学生姓名',
    wt_sex VARCHAR(6) CHECK ( wt_sex= 'male'OR wt_sex='female' OR wt_sex='男' OR wt_sex='女' ) COMMENT '性别',
    wt_sage INT CHECK ( wt_sage >0 AND wt_sage<120)COMMENT '年龄' ,
    wt_sori VARCHAR(30) COMMENT '生源地',
    wt_scredits INT DEFAULT 0 COMMENT '总学分',
    wt_collid INT COMMENT '所属学院编号',
    wt_mno INT COMMENT '所属专业编号',
    wt_classno INT COMMENT '所属班级编号',
    PRIMARY KEY pk_sno (wt_sno) COMMENT '主键',
    CONSTRAINT FOREIGN KEY fk_collid (wt_collid) REFERENCES wt_ums_college(wt_collid) ON DELETE SET NULL ,
    CONSTRAINT FOREIGN KEY fk_mno (wt_mno) REFERENCES  wt_ums_major(wt_mno) ON DELETE SET NULL ,
    CONSTRAINT FOREIGN KEY fk_classno (wt_classno) REFERENCES wt_ums_class(wt_classno) ON DELETE SET NULL
)ENGINE =InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_students ADD UNIQUE (wt_id);

# 学生健康码
CREATE TABLE wt_ums_stu_healthcode(
    wt_sid INT UNSIGNED COMMENT '学生学号',
    wt_code_color VARCHAR(7) COMMENT '码颜色',
    CONSTRAINT FOREIGN KEY fk_sid (wt_sid) REFERENCES wt_ums_students(wt_sno) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_stu_healthcode ADD PRIMARY KEY (wt_sid);


# 教师健康码
CREATE TABLE wt_ums_tea_healthcode(
    wt_tid INT COMMENT '教师编号',
    wt_code_color VARCHAR(7) COMMENT '颜色',
    CONSTRAINT FOREIGN KEY fk_tid (wt_tid) REFERENCES wt_ums_teachers(wt_tid) ON DELETE CASCADE
)ENGINE = InnoDB,charset =utf8mb4;
ALTER TABLE wt_ums_tea_healthcode ADD PRIMARY KEY (wt_tid);

# 教师打卡表
CREATE TABLE wt_ums_tea_check(
    wt_tid INT COMMENT '教师编号',
    wt_records TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '打卡记录',
    CONSTRAINT FOREIGN KEY fk_tid (wt_tid) REFERENCES wt_ums_teachers(wt_tid) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;

# 学生打卡表
CREATE TABLE wt_ums_stu_check(
    wt_sid INT UNSIGNED COMMENT '学生编号',
    wt_records TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '打卡记录',
    CONSTRAINT FOREIGN KEY fk_sid (wt_sid) REFERENCES wt_ums_students(wt_sno) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;

# 教师课程表
CREATE TABLE wt_ums_tea_cour(
    wt_tid INT COMMENT '教师编号',
    wt_cno INT COMMENT '课程编号',
    FOREIGN KEY fk_tid(wt_tid) REFERENCES wt_ums_teachers(wt_tid) ON DELETE CASCADE ,
    FOREIGN KEY fk_cno (wt_cno) REFERENCES wt_ums_course(wt_cno) ON DELETE CASCADE
)ENGINE =InnoDB,charset =utf8mb4;

# 学生成绩表
# 学号PK(FK) 学期 课程编号PK(FK) 成绩 教师编号FK
CREATE TABLE wt_stu_score(
    wt_sno INT UNSIGNED COMMENT '学号',
    wt_cterm INT COMMENT '学期',
    wt_cno INT COMMENT '课程编号',
    wt_score DECIMAL(3,1) COMMENT '成绩',
    wt_tid INT COMMENT '教师编号',
    PRIMARY KEY (wt_sno,wt_cno) ,
    FOREIGN KEY fk_sno (wt_sno) REFERENCES wt_ums_students(wt_sno) ON DELETE CASCADE ,
    FOREIGN KEY fk_cno(wt_cno) REFERENCES wt_ums_course(wt_cno) ON DELETE CASCADE ,
    FOREIGN KEY fk_tid(wt_tid) REFERENCES wt_ums_teachers(wt_tid) ON DELETE SET NULL
)ENGINE =InnoDB,charset =utf8mb4;




