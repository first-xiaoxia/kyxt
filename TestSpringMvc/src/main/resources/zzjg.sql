SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `organiseunit`;
CREATE TABLE `organiseunit` (
  `ID` 				bigint(20) NOT NULL,
  `NAME` 			varchar(255) DEFAULT NULL COMMENT '机构名称',
  `PARENT_ID` 		bigint(20) DEFAULT NULL COMMENT '父节点ID',
  `DWBH` 			varchar(255) DEFAULT NULL COMMENT '单位编号',
  `DWLX` 			int(4) DEFAULT NULL COMMENT '单位类型(1:管理机构 2:院系 3:研究机构)',
  `MEMO` 			varchar(526) DEFAULT NULL COMMENT '描述',
  `HAS_LEAF` 		int(1) DEFAULT NULL COMMENT '是否包含子节点(0:不包含 1:包含）',
  `FZR` 			VARCHAR(50) DEFAULT NULL COMMENT '负责人',
  `LXR` 			VARCHAR(50) DEFAULT NULL COMMENT '联系人',
  `YJXK` 			VARCHAR(50) DEFAULT NULL COMMENT '一级学科',
  `LXDH` 			VARCHAR(11) DEFAULT NULL COMMENT '联系电话',
  `CZ` 				VARCHAR(20) DEFAULT NULL COMMENT '传真',
  `DZ` 				VARCHAR(255) DEFAULT NULL COMMENT '地址',
  `YB` 				VARCHAR(8) DEFAULT NULL COMMENT '邮编',
  `WZ` 				VARCHAR(50) DEFAULT NULL COMMENT '网址',
  `CJDM` 			VARCHAR(255) DEFAULT NULL COMMENT '层级代码',
  `CREATER` 		bigint(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` 	datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATER` 		bigint(20) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` 	datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;