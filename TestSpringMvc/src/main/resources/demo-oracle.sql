DROP TABLE  menu;
create table menu(
       id number(9) not null primary key,
       name varchar2(100) not null,
			 parent_Id number(20) ,
			url VARCHAR2(200),
			DISPLOY_ORDER number(4) DEFAULT NULL,
			MEMO VARCHAR2(255) DEFAULT NULL,
			HASLEAF number(1) DEFAULT NULL,
			CREATER number(20) DEFAULT NULL,
			CREATE_TIME date DEFAULT SYSDATE,
			UPDATER number(20) DEFAULT NULL,
			UPDATE_TIME date DEFAULT SYSDATE
			
)  ;
INSERT INTO menu VALUES (1, '学生管理系统', null, '', 1, null, '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'), null, null);
INSERT INTO menu VALUES (2, '用户管理', 1, '', 2, null, '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'), null, null);
INSERT INTO menu VALUES (3, '账号管理', 2, 'sysUser.html', 3, null, '0', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'), null, null);
INSERT INTO menu VALUES (4, '学生管理', 1, null, 4, null, '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'), null, null);
INSERT INTO menu VALUES (5, '学生信息', 4, 'student.html', 5, null, '0', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'), null, null);



CREATE TABLE menurole (
  ID varchar2(20) NOT NULL primary key,
  MENU_ID varchar2(20) DEFAULT NULL,
  ROLE_ID varchar2(20) DEFAULT NULL,
  CREATER varchar2(20) DEFAULT NULL,
  CREATE_TIME date DEFAULT SYSDATE
);


INSERT INTO menurole VALUES ('1', '1', '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));
INSERT INTO menurole VALUES ('2', '1', '2', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));
INSERT INTO menurole VALUES ('3', '2', '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));
INSERT INTO menurole VALUES ('4', '3', '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));
INSERT INTO menurole VALUES ('5', '4', '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));
INSERT INTO menurole VALUES ('6', '4', '2', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));
INSERT INTO menurole VALUES ('7', '5', '1', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));
INSERT INTO menurole VALUES ('8', '5', '2', '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'));



CREATE TABLE role (
  ID varchar2(20) NOT NULL,
  NAME varchar2(100) DEFAULT NULL ,
  MEMO varchar2(255) DEFAULT NULL,
  CREATER varchar2(20) DEFAULT NULL ,
  CREATE_TIME date DEFAULT NULL ,
  UPDATER varchar2(20) DEFAULT NULL ,
  UPDATE_TIME date DEFAULT SYSDATE 
) ;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('1', '管理员', null, '1', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'), null, null);
INSERT INTO role VALUES ('2', '一般用户', null, '2', "TO_DATE"('2017-03-02 15:43:08', 'yyyy-MM-dd hh24:mi:ss'), null, null);

CREATE TABLE students (
  ID varchar2(20) NOT NULL ,
  NAME varchar2(255) DEFAULT NULL ,
  sCLASS varchar2(255) DEFAULT NULL ,
  STUDENT_ID varchar2(20) DEFAULT NULL ,
  age varchar2(20) DEFAULT NULL ,
  height varchar2(10) DEFAULT NULL ,
  weight varchar2(10) DEFAULT NULL ,
  CREATER varchar2(20) DEFAULT NULL,
  CREATE_TIME date DEFAULT NULL  ,
  UPDATER varchar2(20) DEFAULT NULL ,
  UPDATE_TIME date DEFAULT SYSDATE

);

INSERT INTO students VALUES ('1', '盖伦', '1302', '1231302001', '18', '170', '58.6', '1', null, null, null);
INSERT INTO students VALUES ('2', '寒冰', '1302', '1231302002', '21', '165', '49.5', '1', null, '1', null);
INSERT INTO students VALUES ('3', '泰坦', '1303', '1231303001', '19', '166', '55.6', '1', null, null, null);
INSERT INTO students VALUES ('4', '贾克斯', '1303', '1231303002', '18', '156', '55.2', '1', null, null, null);
INSERT INTO students VALUES ('5', '泰隆', '1304', '1231304001', '18', '166', '56.3', '1', null, null, null);
INSERT INTO students VALUES ('6', '烬', '1304', '1304002', '18', '199', '68.2', '1', null, null, null);
INSERT INTO students VALUES ('7', '拉克丝', '1304', '1231304003', '15', '175', '55', '1', null, null, null);
INSERT INTO students VALUES ('8', '提莫', '1304', '1231304004', '12', '60', '42', '1', null, null, null);
INSERT INTO students VALUES ('9', '凯特琳', '1305', '1231305001', '16', '165', '50', '1', null, null, null);
INSERT INTO students VALUES ('10', '卡特琳娜', '1305', '1231305002', '19', '167', '50.2', '1', null, null, null);
INSERT INTO students VALUES ('11', '劫', '1305', '1231305003', '19', '168', '52', '1', null, null, null);
INSERT INTO students VALUES ('12', '马尔扎哈', '1305', '1231305004', '22', '175', '61.0', '1', null, null, null);



CREATE TABLE user_t (
  id varchar2(11) NOT NULL,
  user_name varchar2(40) NOT NULL,
  password varchar2(255) NOT NULL,
  user_type varchar2(11) NOT NULL,
  age varchar2(4) NOT NULL
)

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO user_t VALUES ('1', 'admin', '000000', '1', '22');
INSERT INTO user_t VALUES ('2', 'xiaoxia', '123456', '2', '12');
INSERT INTO user_t VALUES ('3', 'aruan', '123456', '2', '50');
INSERT INTO user_t VALUES ('4', 'aruan', '000000', '2', '22');









