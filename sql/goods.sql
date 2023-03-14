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

 Date: 14/03/2023 16:10:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '创建者',
  `category_id` bigint NULL DEFAULT NULL COMMENT '分类',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock` int NULL DEFAULT NULL COMMENT '库存',
  `sales` int NULL DEFAULT NULL COMMENT '销量',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '封面图',
  `pics` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '小图集',
  `is_on` int NULL DEFAULT NULL COMMENT '是否上架（0：没上架，1：上架）',
  `is_recommend` int NULL DEFAULT NULL COMMENT '是否推荐（0：不推荐，1：推荐）',
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详情',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 1, 225, '荣耀X40', '120Hz OLED硬核曲屏 5100mAh 快充大电池 7.9mm轻薄设计 5G手机 8GB+128GB 彩云追月', 5000.00, 98, 30, 'https://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%95%86%E5%93%81/%E8%8D%A3%E8%80%80X40.png', NULL, 1, 1, '<p>荣耀X40 111</p>', '2023-03-10 15:51:03', '2023-03-13 15:49:27');
INSERT INTO `goods` VALUES (2, 1, 225, 'Redmi K60', '骁龙8+处理器 2K高光屏 6400万超清相机 5500mAh长续航 12GB+256GB 墨羽 小米红米5G', 2699.00, 999, 0, 'http://edu-56632.oss-cn-hangzhou.aliyuncs.com/%E5%95%86%E5%93%81%E5%9B%BE%E7%89%87/f22f2d03-9c36-4365-810a-0c2fe276a034.png', NULL, 0, 0, '<p><strong style=\"color: rgb(102, 102, 102);\">骁龙8+处理器 2K高光屏 6400万超清相机 5500mAh长续航 12GB+256GB 墨羽 小米红米5G</strong></p>', '2023-03-13 10:57:41', '2023-03-13 10:57:41');

SET FOREIGN_KEY_CHECKS = 1;
