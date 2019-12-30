/*
 Navicat Premium Data Transfer

 Source Server         : mysqlconncter
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 30/12/2019 20:14:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, '英雄联盟');
INSERT INTO `t_category` VALUES (2, '刺客信条');
INSERT INTO `t_category` VALUES (3, '绝地求生');

-- ----------------------------
-- Table structure for t_common
-- ----------------------------
DROP TABLE IF EXISTS `t_common`;
CREATE TABLE `t_common`  (
  `coid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `updatetime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `maincommon` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`coid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_common
-- ----------------------------
INSERT INTO `t_common` VALUES (1, 26, 6, '2019-12-20 16:57:33', '<div></div><p><prearial\';font-size:13.5pt;\">随便评论一些什么，让你感觉我看过了</prearial\';font-size:13.5pt;\"><br></p>');
INSERT INTO `t_common` VALUES (2, 43, 6, '2019-12-22 11:10:56', '<div></div><p><prearial\';font-size:13.5pt;\">宁说得对，IG野区栓条狗都能赢。<img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"></prearial\';font-size:13.5pt;\"><br></p>');
INSERT INTO `t_common` VALUES (3, 44, 5, '2019-12-22 11:10:56', '112233');
INSERT INTO `t_common` VALUES (4, 43, 4, '2019-12-22 16:29:32', '<p></p><p><img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"></p><p>你猜猜怎么打？&nbsp;<br></p>');
INSERT INTO `t_common` VALUES (5, 43, 5, '2019-12-22 16:36:18', '<p></p><p>估计不好，怎么着也得等到巴黎圣母院再烧一次了<img src=\"https://img.nga.178.com/attachments/mon_201209/14/-47218_5052bc4cc6331.png\" \"=\"\"></p>');
INSERT INTO `t_common` VALUES (6, 26, 4, '2019-12-22 16:38:58', '<p><img onload=\"ubbcode.adjImgSize(this);\" src=\"https://img.nga.178.com/attachments/mon_201209/14/-47218_5052bc4cc6331.png\" \"=\"\" onerror=\"ubbcode.imgError(this)\">&nbsp;我太难了&nbsp;<br></p>');
INSERT INTO `t_common` VALUES (7, 26, 4, '2019-12-22 17:59:29', '<p><img src=\"https://img.nga.178.com/attachments/mon_201910/09/-jx594Q5-hwcKxToS3m-3m.png\">&nbsp;</p><p>哎嘿</p><blockquote>啊啊啊&nbsp;</blockquote>');
INSERT INTO `t_common` VALUES (8, 26, 5, '2019-12-27 18:05:32', '<p></p><p>宁看看楼上说的是人话吗？</p>');

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `topicname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `heat` int(11) DEFAULT NULL,
  `htmlmainbody` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `mainbody` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createtime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `updatetime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_topic
-- ----------------------------
INSERT INTO `t_topic` VALUES (1, '这是啥', 26, 1, 11, NULL, '测试2', NULL, NULL);
INSERT INTO `t_topic` VALUES (4, '奥恩怎么打蛮子', 26, 1, 3, '<p></p><p>这咋打嘛！<br>今天打奥恩遇见个蛮子，被锤爆了。想问一下大家奥恩怎么打蛮子？<img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"><img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"><img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"><img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\">&nbsp;&nbsp;<br></p>', '今天打奥恩遇见个蛮子，被锤爆了。想问一下大家奥恩怎么打蛮子？', '2019-12-20 16:54:33', '2019-12-22 17:59:29');
INSERT INTO `t_topic` VALUES (5, '育碧什么时候重制二代三部曲', 26, 2, 3, '<div></div><p><prearial\';font-size:13.5pt;\">RT，育碧什么时候重制二代三部曲</prearial\';font-size:13.5pt;\"><br></p>', 'RT，育碧什么时候重制二代三部曲', '2019-12-20 16:57:33', '2019-12-27 18:05:32');
INSERT INTO `t_topic` VALUES (7, 'leyan真下饭啊，强刷对面石头人把自己刷空血了', 43, 1, 2, '<p></p><p>对面豹女3-0了<img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"><img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"><img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\"><img src=\"https://img4.nga.178.com/ngabbs/post/smile/ac18.png\" alt=\"喷\">&nbsp;&nbsp;<br></p>', '对面豹女3-0了。', '2019-12-22 11:38:02', '2019-12-22 11:38:02');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `access` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'defaultuser',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES (23, '张三', '123456', 'defaultuser', '男', '1999-10-11', 'unknown.png', NULL, NULL);
INSERT INTO `t_users` VALUES (24, '张三', '1234', 'defaultuser', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (26, 'zhangs', '1234', 'admin', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (27, '孙悟空', '199999', 'defaultuser', NULL, '1999-10-11', NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (33, '孙悟', '199999', 'defaultuser', NULL, '1999-10-11', NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (34, 'mina', '1234', 'defaultuser', '', '1999-10-11', NULL, '', '');
INSERT INTO `t_users` VALUES (35, '悟', '199999', 'defaultuser', NULL, '1999-10-11', NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (36, '1231', '199999', 'defaultuser', NULL, '1999-10-11', NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (37, '123', '199999', 'defaultuser', NULL, '1999-10-11', NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (38, '1223', '199999', 'defaultuser', NULL, '1999-10-11', NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (39, '1561', '132', 'defaultuser', NULL, '1999-10-11', NULL, '', '');
INSERT INTO `t_users` VALUES (40, '1231', '11111', 'defaultuser', '汉子', '', NULL, '', '');
INSERT INTO `t_users` VALUES (41, '1233323', '199999', 'defaultuser', NULL, '1999-10-11', NULL, NULL, NULL);
INSERT INTO `t_users` VALUES (42, 'yang', '1123', 'defaultuser', '妹纸', '', NULL, '', '');
INSERT INTO `t_users` VALUES (43, 'mimi', '123', 'defaultuser', '妹纸', '', NULL, '', '');
INSERT INTO `t_users` VALUES (44, '大傻子', '123111', 'defaultuser', '', '2019-00-12', NULL, '', '');
INSERT INTO `t_users` VALUES (45, '大傻子2', '123111', 'defaultuser', '', '2019-00-22', NULL, '', '');
INSERT INTO `t_users` VALUES (46, 'woca', '1234', 'defaultuser', '', '2019-12-04', NULL, '', '');
INSERT INTO `t_users` VALUES (47, 'root', '1234', 'admin', '汉子', '1992-10-08', NULL, 'qqq8437@qq.com', '15588888888');
INSERT INTO `t_users` VALUES (48, 'dashazi', '123123', 'defaultuser', '汉子', '1991-07-15', NULL, '', '');
INSERT INTO `t_users` VALUES (49, '1231234', '123123', 'defaultuser', '不告诉你', '2019-09-03', NULL, '', '');
INSERT INTO `t_users` VALUES (50, '3213132', '123123', 'defaultuser', '', '', NULL, '', '');
INSERT INTO `t_users` VALUES (51, 'asdasd', '111111', 'defaultuser', '', '', NULL, '', '');
INSERT INTO `t_users` VALUES (52, '11111', '1111', 'defaultuser', '', '', NULL, '', '');
INSERT INTO `t_users` VALUES (53, '2222', '2222', 'defaultuser', '', '', NULL, '', '');

SET FOREIGN_KEY_CHECKS = 1;
