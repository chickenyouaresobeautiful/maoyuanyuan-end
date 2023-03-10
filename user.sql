/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : antd_pro

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 10/03/2023 16:57:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `realname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '封禁状态',
  `register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `register_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '注册ip',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin', '成都', '15549201757', 1, '2023-02-24 16:33:34', '', 'https://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%A4%B4%E5%83%8F/avatar.jpg', '2638502607@qq.com');
INSERT INTO `user` VALUES (4, 'admin1', 'admin1', NULL, NULL, '15549201758', 0, '2023-03-10 09:12:17', NULL, 'http://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%A4%B4%E5%83%8F/b1a3f4db-b68f-46a4-b3b7-bee33a7bea2a.jpg', 'admin1@cxk.com');
INSERT INTO `user` VALUES (5, 'admin2', 'admin2', NULL, NULL, '15549201759', 0, '2023-03-10 09:47:46', NULL, 'http://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%A4%B4%E5%83%8F/3118d50d-d846-44fa-b355-a9f3c44a4372.jpg', 'admin2@cxk.com');

SET FOREIGN_KEY_CHECKS = 1;
