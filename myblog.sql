/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-20 18:20:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `describes` varchar(255) NOT NULL,
  `content` text,
  `create_date` datetime NOT NULL,
  `comment_count` int(11) NOT NULL COMMENT '评论数',
  `category` varchar(32) NOT NULL,
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键字',
  `click` mediumint(255) DEFAULT NULL COMMENT '点击量',
  PRIMARY KEY (`id`),
  KEY `date_index` (`create_date`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '', '', '<p>dfsff2017-12-14 14:11:56 星期四2017-12-14 14:11:57 星期四</p>\n<blockquote>\n<ul>\n<li>**~~<em>2017-12-14 14:12:23 星期四2017-12-14 14:12:25 星期四\n[========]\n<em>~~</em></em></li>\n</ul>\n</blockquote>\n', '2017-12-14 14:12:34', '0', 'Java', null, null);

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `id` int(11) NOT NULL COMMENT '主键id',
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `user_name` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `user_url` varchar(255) DEFAULT NULL COMMENT '个人网址',
  `user_email` varchar(255) DEFAULT NULL COMMENT '个人邮箱',
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', '自传', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) NOT NULL COMMENT '登录名',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  `head_url` varchar(256) DEFAULT '',
  `role` varchar(32) DEFAULT 'user',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `brief` varchar(255) DEFAULT NULL COMMENT '简介',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'roger', 'roger', 'e10adc3949ba59abbe56e057f20f883e', 'https://images.nowcoder.com/head/929m.png', 'admin', '154271254@qq.com', null, '1');
INSERT INTO `user` VALUES ('2', 'luojie', '罗杰', 'e10adc3949ba59abbe56e057f20f883e', null, null, '123@qq.com', null, '0');
INSERT INTO `user` VALUES ('4', 'kangyuan', '康园', '827ccb0eea8a706c4c34a16891f84e7b', null, null, '123@qq.com', null, '0');
INSERT INTO `user` VALUES ('17', 'seven', '七毛娃', 'e10adc3949ba59abbe56e057f20f883e', null, null, '123@qq.com', null, '0');
INSERT INTO `user` VALUES ('18', 'haha', '哈哈', 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, '0');
INSERT INTO `user` VALUES ('19', 'heihei', '嘿嘿', 'e10adc3949ba59abbe56e057f20f883e', null, null, '123@qq.com', null, '0');
