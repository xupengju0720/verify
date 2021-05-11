/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : config

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 11/05/2021 17:21:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for common_paramdb
-- ----------------------------
DROP TABLE IF EXISTS `common_paramdb`;
CREATE TABLE `common_paramdb`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_mark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `param_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `param_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_value` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  `user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_project_mark_param_key`(`project_mark`, `param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_paramdb
-- ----------------------------
INSERT INTO `common_paramdb` VALUES (1, 'demo', 'http.ip', '127.0.0.1', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (2, 'demo', 'http.port', '8080', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (3, 'demo', 'http.type', '1', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (4, 'demo', 'http.name', 'demo', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (5, 'demo', 'spring.redis.usewhichflag', '1', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (6, 'demo', 'spring.redis.redis', 'redis', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (7, 'demo', 'spring.redis.local', 'local', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (8, 'demo', 'spring.redis.host', '127.0.0.1', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (9, 'demo', 'spring.redis.port', '6379', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (10, 'demo', 'spring.redis.password', '123456', '0', 'SYS');
INSERT INTO `common_paramdb` VALUES (11, 'demo', 'spring.redis.database', '0', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (12, 'demo', 'spring.redis.lettuce.pool.max-active', '32', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (13, 'demo', 'spring.redis.lettuce.pool.max-wait', '300ms', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (14, 'demo', 'spring.redis.lettuce.pool.max-idle', '16', '1', 'SYS');
INSERT INTO `common_paramdb` VALUES (15, 'demo', 'spring.redis.lettuce.pool.min-idle', '8', '1', 'SYS');

SET FOREIGN_KEY_CHECKS = 1;
