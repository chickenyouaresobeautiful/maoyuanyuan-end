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

 Date: 14/03/2023 16:11:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增长主键ID',
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单号',
  `user_id` bigint NULL DEFAULT NULL COMMENT '创建者',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `status` int NULL DEFAULT NULL COMMENT '状态（1.下单；2.支付；3.发货；4.收货；5.过期）',
  `address_id` int NULL DEFAULT NULL COMMENT '收货地址',
  `express_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '快递类型',
  `express_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '快递号',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付类型',
  `trade_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付流水号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '1', 1, 12699.00, 3, 1, 'SF', 'jinitaimei', '2023-03-13 16:27:56', '支付宝', '1', '2023-03-13 16:27:48', '2023-03-14 15:53:48');

SET FOREIGN_KEY_CHECKS = 1;
