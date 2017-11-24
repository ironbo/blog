/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-11-16 16:37:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `BLOG_COMMENT`
-- ----------------------------
DROP TABLE IF EXISTS `BLOG_COMMENT`;
CREATE TABLE `BLOG_COMMENT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(500) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `ESSAY_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of BLOG_COMMENT
-- ----------------------------

-- ----------------------------
-- Table structure for `BLOG_ESSAY`
-- ----------------------------
DROP TABLE IF EXISTS `BLOG_ESSAY`;
CREATE TABLE `BLOG_ESSAY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUTHOR_ID` int(11) DEFAULT NULL,
  `CONTENT` varchar(2000) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `IS_SHARE` varchar(1) DEFAULT '0',
  `PIC_PATH` varchar(50) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `WEATHER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of BLOG_ESSAY
-- ----------------------------

-- ----------------------------
-- Table structure for `BLOG_LIKED_CONTENT`
-- ----------------------------
DROP TABLE IF EXISTS `BLOG_LIKED_CONTENT`;
CREATE TABLE `BLOG_LIKED_CONTENT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_TIME` datetime DEFAULT NULL,
  `ESSAY_ID` int(11) DEFAULT NULL,
  `FLAG` varchar(10) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of BLOG_LIKED_CONTENT
-- ----------------------------

-- ----------------------------
-- Table structure for `BLOG_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `BLOG_ROLE`;
CREATE TABLE `BLOG_ROLE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(10) DEFAULT NULL,
  `DESC` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_5pduydof7yta2kidhmsx8jpuc` (`ROLE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of BLOG_ROLE
-- ----------------------------
INSERT INTO `BLOG_ROLE` VALUES ('1', 'ADMIN', null);
INSERT INTO `BLOG_ROLE` VALUES ('2', 'USER', null);

-- ----------------------------
-- Table structure for `BLOG_USER`
-- ----------------------------
DROP TABLE IF EXISTS `BLOG_USER`;
CREATE TABLE `BLOG_USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AVATAR_URL` varchar(20) DEFAULT NULL,
  `CITY` varchar(20) DEFAULT NULL,
  `COUNTRY` varchar(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `EMAIL` varchar(20) NOT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  `NICK` varchar(20) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `PROVINCE` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_5pduydof7yta9kidhmsx8jpuc` (`EMAIL`),
  UNIQUE KEY `UK_hn5on4pmd3uj3ifkj3vwdk845` (`NICK`),
  UNIQUE KEY `UK_b9kx514948d0d4s4i9mvlcusi` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of BLOG_USER
-- ----------------------------
INSERT INTO `BLOG_USER` VALUES ('1', null, '', '', null, 'iron_bo@126.com', '1', '波波', '$2a$10$PE8LsE4mWekG.NUxU9XftO3LRbvwDcQlmWJZjE6289KYotYrM7Dki', '', 'bobo');

-- ----------------------------
-- Table structure for `BLOG_USER_ROLE`
-- ----------------------------
DROP TABLE IF EXISTS `BLOG_USER_ROLE`;
CREATE TABLE `BLOG_USER_ROLE` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  KEY `FKoydn1vxkuuknbtvgk8cmfn40q` (`ROLE_ID`),
  KEY `FK8mw8mkkl54flcwg59580pllac` (`USER_ID`),
  CONSTRAINT `FK8mw8mkkl54flcwg59580pllac` FOREIGN KEY (`USER_ID`) REFERENCES `BLOG_USER` (`ID`),
  CONSTRAINT `FKoydn1vxkuuknbtvgk8cmfn40q` FOREIGN KEY (`ROLE_ID`) REFERENCES `BLOG_ROLE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of BLOG_USER_ROLE
-- ----------------------------
INSERT INTO `BLOG_USER_ROLE` VALUES ('1', '2');
