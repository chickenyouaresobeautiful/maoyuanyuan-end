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

 Date: 10/03/2023 16:57:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '创建者',
  `category_id` bigint(0) NULL DEFAULT NULL COMMENT '分类',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock` int(0) NULL DEFAULT NULL COMMENT '库存',
  `sales` int(0) NULL DEFAULT NULL COMMENT '销量',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '封面图',
  `pics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '小图集',
  `is_on` int(0) NULL DEFAULT NULL COMMENT '是否上架（0：没上架，1：上架）',
  `is_recommend` int(0) NULL DEFAULT NULL COMMENT '是否推荐（0：不推荐，1：推荐）',
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详情',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 1, 2, '荣耀X40', '120Hz OLED硬核曲屏 5100mAh 快充大电池 7.9mm轻薄设计 5G手机 8GB+128GB 彩云追月', 5000.00, 100, 30, 'https://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%95%86%E5%93%81/%E8%8D%A3%E8%80%80X40.png', NULL, 0, 1, NULL, '2023-03-10 15:51:03', '2023-03-10 15:51:05');

SET FOREIGN_KEY_CHECKS = 1;
