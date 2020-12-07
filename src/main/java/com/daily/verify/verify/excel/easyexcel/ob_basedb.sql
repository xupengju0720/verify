/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : ob_basedb

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 04/12/2020 18:59:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_accounts
-- ----------------------------
DROP TABLE IF EXISTS `t_accounts`;
CREATE TABLE `t_accounts`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `stkbd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `account_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `account_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `account_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `capital_attr` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `offer_account_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `fund_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `branch_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `market_id` smallint(6) NULL DEFAULT NULL,
  `pbuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `assignment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `assignment_seat` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `check_fund` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `check_share` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `open_account_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `open_date` date NULL DEFAULT NULL,
  `close_date` date NULL DEFAULT NULL,
  `data_status` tinyint(255) NULL DEFAULT NULL,
  `offer_pbu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `partition` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `add_time` bigint(20) NULL DEFAULT NULL,
  `add_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `update_time` bigint(20) NULL DEFAULT NULL,
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_accounts
-- ----------------------------
INSERT INTO `t_accounts` VALUES (1, '1', '1', 'SSH10101013', '1', '1', '1', '1', '1', '1', '1', 1, '1', '1', '1', '1', '1', '1', '2020-12-03', '2020-12-03', 1, '1', '1', 1, '1', 1, '1');

-- ----------------------------
-- Table structure for t_customers
-- ----------------------------
DROP TABLE IF EXISTS `t_customers`;
CREATE TABLE `t_customers`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户号',
  `cust_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户类型',
  `cust_cls` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户分类',
  `cust_group_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户组类型',
  `cust_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户状态',
  `cust_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户名称',
  `certificate_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '证书类型',
  `certificate_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '证书号',
  `certificate_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '证书地址',
  `certificate_issue_agency` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '证书发行机关',
  `certificate_expiry_date` date NULL DEFAULT NULL COMMENT '证书过期日期',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `broker_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '经纪人',
  `agent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '代理人',
  `contract_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系电话',
  `contract_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系地址',
  `mobile_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '移动电话',
  `fax` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '传真',
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地区',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `cust_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户标识',
  `zip_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮编',
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职业',
  `order_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '委托方式',
  `warning_attr` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '警示属性',
  `risk_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '风险类别',
  `invest_period` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '投资期限',
  `open_date` date NULL DEFAULT NULL COMMENT '开户日期',
  `close_date` date NULL DEFAULT NULL COMMENT '销户日期',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `data_status` tinyint(1) NULL DEFAULT NULL COMMENT '数据状态: -2:未更新 -1:删除 0:新增 1:已更新',
  `deletable` bit(1) NULL DEFAULT NULL COMMENT '是否可删除',
  `add_time` bigint(20) NULL DEFAULT NULL COMMENT 'add_time',
  `add_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'add_user',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT 'update_time',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'update_user',
  `pass_word` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '客户密码',
  `pwd_type` tinyint(4) NULL DEFAULT NULL COMMENT '密码类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customers
-- ----------------------------
INSERT INTO `t_customers` VALUES (1, '10000112', '1', '1', '1', '1', '小红', '1', '433229199902030729', '1', '1', '2020-11-30', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2020-11-30', '2020-11-30', '1', 1, b'1', 1, '1', 1, '1', '*12345678*', 1);
INSERT INTO `t_customers` VALUES (2, '10000113', '2', '2', NULL, '0', '小张2', '1', '433229199902030020', 'null', 'null', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2020-07-11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '*12345678*加密值', 1);
INSERT INTO `t_customers` VALUES (3, '10000114', '1', '3', 'null', '0', '小张3', '2', '433229199902030000', 'null', 'null', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2020-07-12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '*12345678*加密值', 1);
INSERT INTO `t_customers` VALUES (4, '10000115', '2', '1', '1', '0', '小强', '3', '433229199902030000', '1', '1', '2020-11-30', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, '2020-12-02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '加密值', 1);

SET FOREIGN_KEY_CHECKS = 1;
