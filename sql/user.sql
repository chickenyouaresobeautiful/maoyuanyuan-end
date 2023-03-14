/*
 Navicat Premium Data Transfer

 Source Server         : 主机Mysql
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : localhost:3306
 Source Schema         : antd_pro

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 14/03/2023 16:11:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `realname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint NULL DEFAULT NULL COMMENT '封禁状态',
  `register_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `register_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '注册ip',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'admin', '成都', '15549201757', 0, '2023-02-24 16:33:34', '', 'https://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%A4%B4%E5%83%8F/avatar.jpg', '2638502607@qq.com');
INSERT INTO `user` VALUES (4, 'admin1', 'admin1', NULL, NULL, '15549201758', 0, '2023-03-10 09:12:17', NULL, 'http://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%A4%B4%E5%83%8F/b1a3f4db-b68f-46a4-b3b7-bee33a7bea2a.jpg', 'admin1@cxk.com');
INSERT INTO `user` VALUES (5, 'admin2', 'admin2', NULL, NULL, '15549201759', 0, '2023-03-10 09:47:46', NULL, 'http://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%A4%B4%E5%83%8F/3118d50d-d846-44fa-b355-a9f3c44a4372.jpg', 'admin2@cxk.com');
INSERT INTO `user` VALUES (6, 'admin3', 'admin3', NULL, NULL, '15549201760', 0, '2023-03-13 15:05:13', NULL, 'http://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%A4%B4%E5%83%8F/a2f14dac-68e6-455e-bcc2-564f2535b367.jpg', 'admin3@cxq.com');

SET FOREIGN_KEY_CHECKS = 1;
