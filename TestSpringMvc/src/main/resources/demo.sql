/*
Navicat MySQL Data Transfer

Source Server         : mytest
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-03-22 09:49:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父节点ID',
  `URL` varchar(255) DEFAULT NULL COMMENT '路径',
  `DISPLOY_ORDER` int(4) DEFAULT NULL COMMENT '显示顺序',
  `MEMO` varchar(255) DEFAULT NULL COMMENT '描述',
  `HAS_LEAF` int(1) DEFAULT NULL COMMENT '是否包含子节点(0:不包含 1:包含）',
  `CREATER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATER` bigint(20) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '学生管理系统', null, '', '1', null, '1', '1', '2017-03-02 15:43:08', null, null);
INSERT INTO `menu` VALUES ('2', '用户管理', '1', '', '2', null, '1', '1', '2017-03-02 15:44:12', null, null);
INSERT INTO `menu` VALUES ('3', '账号管理', '2', 'sysUser.html', '3', null, '0', '1', '2017-03-02 15:50:25', null, null);
INSERT INTO `menu` VALUES ('4', '学生管理', '1', null, '4', null, '1', '1', '2017-03-02 16:06:56', null, null);
INSERT INTO `menu` VALUES ('5', '学生信息', '4', 'student.html', '5', null, '0', '1', '2017-03-02 16:07:33', null, null);

-- ----------------------------
-- Table structure for menurole
-- ----------------------------
DROP TABLE IF EXISTS `menurole`;
CREATE TABLE `menurole` (
  `ID` bigint(20) NOT NULL COMMENT 'id',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色id',
  `CREATER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menurole
-- ----------------------------
INSERT INTO `menurole` VALUES ('1', '1', '1', 'admin', '2017-03-02 15:47:44');
INSERT INTO `menurole` VALUES ('2', '1', '2', 'admin', '2017-03-02 15:48:09');
INSERT INTO `menurole` VALUES ('3', '2', '1', 'admin', '2017-03-02 15:51:16');
INSERT INTO `menurole` VALUES ('4', '3', '1', 'admin', '2017-03-02 15:51:36');
INSERT INTO `menurole` VALUES ('5', '4', '1', 'admin', '2017-03-02 15:51:45');
INSERT INTO `menurole` VALUES ('6', '4', '2', 'admin', '2017-03-02 16:17:56');
INSERT INTO `menurole` VALUES ('7', '5', '1', 'admin', '2017-03-02 16:18:09');
INSERT INTO `menurole` VALUES ('8', '5', '2', 'admin', '2017-03-02 16:18:22');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL COMMENT '角色名',
  `MEMO` varchar(255) DEFAULT NULL COMMENT '描述',
  `CREATER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATER` bigint(20) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', null, 'admin', '2017-03-02 15:46:39', null, null);
INSERT INTO `role` VALUES ('2', '一般用户', null, 'admin', '2017-03-02 15:47:05', null, null);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生表ID',
  `NAME` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sCLASS` varchar(255) DEFAULT NULL COMMENT '班级',
  `STUDENT_ID` bigint(20) DEFAULT NULL COMMENT '学号',
  `age` bigint(20) DEFAULT NULL COMMENT '年龄',
  `height` varchar(10) DEFAULT NULL COMMENT '身高',
  `weight` varchar(10) DEFAULT NULL COMMENT '体重',
  `CREATER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATER` bigint(20) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`),
  KEY `ID` (`ID`),
  KEY `StudentID` (`STUDENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', '盖伦', '1302', '1231302001', '18', '170', '58.6', '1', '2017-03-02 16:00:42', null, null);
INSERT INTO `students` VALUES ('2', '寒冰', '1302', '1231302002', '21', '165', '49.5', '1', '2017-03-02 16:01:10', '1', '2017-03-20 14:49:28');
INSERT INTO `students` VALUES ('3', '泰坦', '1303', '1231303001', '19', '166', '55.6', '1', '2017-03-02 16:02:16', null, null);
INSERT INTO `students` VALUES ('4', '贾克斯', '1303', '1231303002', '18', '156', '55.2', '1', '2017-03-02 16:02:46', null, null);
INSERT INTO `students` VALUES ('5', '泰隆', '1304', '1231304001', '18', '166', '56.3', '1', '2017-03-20 15:46:13', null, null);
INSERT INTO `students` VALUES ('6', '烬', '1304', '1304002', '18', '199', '68.2', '1', '2017-03-20 15:48:41', null, null);
INSERT INTO `students` VALUES ('7', '拉克丝', '1304', '1231304003', '15', '175', '55', '1', '2017-03-20 15:50:02', null, null);
INSERT INTO `students` VALUES ('8', '提莫', '1304', '1231304004', '12', '60', '42', '1', '2017-03-20 15:52:36', null, null);
INSERT INTO `students` VALUES ('9', '凯特琳', '1305', '1231305001', '16', '165', '50', '1', '2017-03-20 15:54:31', null, null);
INSERT INTO `students` VALUES ('10', '卡特琳娜', '1305', '1231305002', '19', '167', '50.2', '1', '2017-03-20 15:56:50', null, null);
INSERT INTO `students` VALUES ('11', '劫', '1305', '1231305003', '19', '168', '52', '1', '2017-03-20 15:58:52', null, null);
INSERT INTO `students` VALUES ('12', '马尔扎哈', '1305', '1231305004', '22', '175', '61.0', '1', '2017-03-20 16:01:49', null, null);

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
  `yhmc` VARCHAR(40) COMMENT '用户名称',
   `yhxb` VARCHAR(40) COMMENT '性别',
   `sfzhm` VARCHAR(40) COMMENT '身份证号码',
  `jslb` VARCHAR(40) COMMENT '教师类别',
  `user_name` varchar(40) NOT NULL COMMENT '登录账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `user_type` int(11) NOT NULL COMMENT '用户类型'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
INSERT INTO `t_user`  VALUES ('1', '管理员', '男', '430411192010186811', '管理岗', 'admin', 'admin', '1');

INSERT INTO `t_user`  VALUES ('2', '用户', '男', '430411192010186811', '教师岗', 'xiaoxia', '000000', '2');

create table t_kyxm(
	xmlsh VARCHAR(40) not null COMMENT '项目流水号',
  xmmc varchar(100) COMMENT '项目名称',
  xmxz varchar(100) COMMENT '项目性质1国家级2省级3省级一下4其他',
  fzr VARCHAR(40) COMMENT '负责人',
  xkfl VARCHAR(40) COMMENT '学科分类',
  kssj datetime COMMENT '开始时间',
  jhwcsj datetime COMMENT '计划完成时间',
  xmcyry VARCHAR(40) COMMENT '项目参与人员',
  PRIMARY KEY (`xmlsh`)
);