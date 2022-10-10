/*
 Navicat Premium Data Transfer

 Source Server         : Book
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 17/12/2021 12:00:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sales` int NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  `img_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, '红楼梦', 80.00, '曹雪芹', 10006, 65, 'static/img/1.jpeg');
INSERT INTO `t_book` VALUES (2, 'java编程思想', 78.50, 'Bruce', 121, 69, 'static/img/2.jpeg');
INSERT INTO `t_book` VALUES (3, '计算机网络', 68.00, '谢希仁', 100013, 38, 'static/img/3.jpeg');
INSERT INTO `t_book` VALUES (4, '钢铁是怎样练成的', 25.00, '奥斯特洛夫斯基', 1011, 39, 'static/img/4.jpeg');
INSERT INTO `t_book` VALUES (5, 'C++编程思想', 45.50, '刚哥', 14, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (6, '虚怀若谷', 29.00, '半夏', 12, 53, 'static/img/5.jpeg');
INSERT INTO `t_book` VALUES (7, '朱颜瘦', 66.50, '西渡', 126, 534, 'static/img/6.jpeg');
INSERT INTO `t_book` VALUES (8, '操作系统', 99.50, '强哥', 48, 35, 'static/img/7.jpg');
INSERT INTO `t_book` VALUES (9, '昆虫记', 9.90, '达尔文', 85, 95, 'static/img/8.jpeg');
INSERT INTO `t_book` VALUES (11, 'C语言程序设计', 28.00, '谭浩强', 52, 74, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (12, 'Lua语言程序设计', 51.50, '雷丰阳', 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (13, '三国演义', 12.00, '罗贯中', 19, 9999, 'static/img/9.jpeg');
INSERT INTO `t_book` VALUES (14, '水浒传', 33.05, '华仔', 22, 88, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (15, '西游记', 133.05, '吴承恩', 122, 188, 'static/img/10.jpg');
INSERT INTO `t_book` VALUES (16, '数据结构 java版', 173.15, '封大神', 21, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (31, '修改了哈哈哈', 95.00, '大牛', 5500, 55, 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `status` int NOT NULL DEFAULT 0,
  `user_id` int NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('16232071524751', '2021-06-09 10:52:32', 246.50, 0, 1);
INSERT INTO `t_order` VALUES ('16232074739881', '2021-06-09 10:57:53', 242.50, 0, 1);
INSERT INTO `t_order` VALUES ('16232074879891', '2021-06-09 10:58:07', 78.50, 0, 1);
INSERT INTO `t_order` VALUES ('16232217607391', '2021-06-09 14:56:00', 242.50, 0, 1);
INSERT INTO `t_order` VALUES ('16232979965131', '2021-06-10 12:06:36', 713.00, 0, 1);
INSERT INTO `t_order` VALUES ('163914421020411', '2021-12-10 21:50:10', 93.00, 0, 11);
INSERT INTO `t_order` VALUES ('16391475791731', '2021-12-10 22:46:19', 161.00, 0, 1);
INSERT INTO `t_order` VALUES ('16391476748001', '2021-12-10 22:47:54', 68.00, 0, 1);
INSERT INTO `t_order` VALUES ('16391476887301', '2021-12-10 22:48:08', 171.50, 0, 1);
INSERT INTO `t_order` VALUES ('16391862823401', '2021-12-11 09:31:22', 93.00, 0, 1);
INSERT INTO `t_order` VALUES ('163918658637412', '2021-12-11 09:36:26', 246.00, 0, 12);
INSERT INTO `t_order` VALUES ('16393852433141', '2021-12-13 16:47:23', 68.00, 0, 1);
INSERT INTO `t_order` VALUES ('163971332383513', '2021-12-17 11:55:23', 25.00, 0, 13);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `total_price` decimal(11, 2) NULL DEFAULT NULL,
  `count` int NOT NULL,
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (2, '数据结构与算法', 78.50, 78.50, 1, '16232071524751');
INSERT INTO `t_order_item` VALUES (4, '数据结构与算法', 78.50, 78.50, 1, '16232074739881');
INSERT INTO `t_order_item` VALUES (5, 'java从入门到放弃', 80.00, 80.00, 1, '16232074739881');
INSERT INTO `t_order_item` VALUES (8, '数据结构与算法', 78.50, 78.50, 1, '16232074879891');
INSERT INTO `t_order_item` VALUES (9, 'java从入门到放弃', 80.00, 80.00, 1, '16232217607391');
INSERT INTO `t_order_item` VALUES (10, '数据结构与算法', 78.50, 78.50, 1, '16232217607391');
INSERT INTO `t_order_item` VALUES (13, 'java从入门到放弃', 80.00, 320.00, 4, '16232979965131');
INSERT INTO `t_order_item` VALUES (14, '数据结构与算法', 78.50, 157.00, 2, '16232979965131');
INSERT INTO `t_order_item` VALUES (17, '计算机网络', 68.00, 68.00, 1, '163914421020411');
INSERT INTO `t_order_item` VALUES (18, '钢铁是怎样练成的', 25.00, 25.00, 1, '163914421020411');
INSERT INTO `t_order_item` VALUES (19, '计算机网络', 68.00, 136.00, 2, '16391475791731');
INSERT INTO `t_order_item` VALUES (20, '钢铁是怎样练成的', 25.00, 25.00, 1, '16391475791731');
INSERT INTO `t_order_item` VALUES (21, '计算机网络', 68.00, 68.00, 1, '16391476748001');
INSERT INTO `t_order_item` VALUES (22, '钢铁是怎样练成的', 25.00, 25.00, 1, '16391476887301');
INSERT INTO `t_order_item` VALUES (23, '计算机网络', 68.00, 68.00, 1, '16391476887301');
INSERT INTO `t_order_item` VALUES (24, 'java编程思想', 78.50, 78.50, 1, '16391476887301');
INSERT INTO `t_order_item` VALUES (25, '计算机网络', 68.00, 68.00, 1, '16391862823401');
INSERT INTO `t_order_item` VALUES (26, '钢铁是怎样练成的', 25.00, 25.00, 1, '16391862823401');
INSERT INTO `t_order_item` VALUES (27, '红楼梦', 80.00, 80.00, 1, '163918658637412');
INSERT INTO `t_order_item` VALUES (28, '朱颜瘦', 66.50, 66.50, 1, '163918658637412');
INSERT INTO `t_order_item` VALUES (29, '操作系统', 99.50, 99.50, 1, '163918658637412');
INSERT INTO `t_order_item` VALUES (30, '计算机网络', 68.00, 68.00, 1, '16393852433141');
INSERT INTO `t_order_item` VALUES (31, '钢铁是怎样练成的', 25.00, 25.00, 1, '163971332383513');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@wzx.com');
INSERT INTO `t_user` VALUES (2, 'wzx168', '123456', '2305456049@qq.com');
INSERT INTO `t_user` VALUES (7, 'wzx666', '123456', 'wzx666@qq.com');
INSERT INTO `t_user` VALUES (8, 'prince', 'fly520', 'prince@qq.com');
INSERT INTO `t_user` VALUES (9, 'julia', 'julia520', '2782947702@qq.com');
INSERT INTO `t_user` VALUES (10, 'Zaza123', 'zaza520', '2305456049@qq.com');
INSERT INTO `t_user` VALUES (11, 'ZaZaXi123', 'wzx457968', '2305456049@qq.com');
INSERT INTO `t_user` VALUES (12, 'Xiaobu123', 'Xiaobu123', '2305456049@qq.com');
INSERT INTO `t_user` VALUES (13, 'wzx123456', 'wzx123456', '2782947702@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
