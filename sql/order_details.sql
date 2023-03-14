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

 Date: 14/03/2023 16:10:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '	自增长主键ID',
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单号',
  `goods_id` bigint NULL DEFAULT NULL COMMENT '商品id',
  `goods_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品标题',
  `goods_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品封面',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `goods_num` int NULL DEFAULT NULL COMMENT '购买商品数',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_details
-- ----------------------------
INSERT INTO `order_details` VALUES (1, '1', 1, '荣耀X40', 'https://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%95%86%E5%93%81/%E8%8D%A3%E8%80%80X40.png', 5000.00, 2, 10000.00);
INSERT INTO `order_details` VALUES (2, '1', 2, 'Redmi K60', 'http://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%95%86%E5%93%81%E5%9B%BE%E7%89%87/f22f2d03-9c36-4365-810a-0c2fe276a034.png', 2699.00, 1, 2699.00);

SET FOREIGN_KEY_CHECKS = 1;
