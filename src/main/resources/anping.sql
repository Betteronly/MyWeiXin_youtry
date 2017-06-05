/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : anping

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-06-05 00:32:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car_order_info
-- ----------------------------
DROP TABLE IF EXISTS `car_order_info`;
CREATE TABLE `car_order_info` (
  `user_no` int(11) DEFAULT NULL,
  `open_id` varchar(20) DEFAULT NULL,
  `addr_from` varchar(255) DEFAULT NULL,
  `addr_to` varchar(255) DEFAULT NULL,
  `depart_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `order_phone` varchar(20) DEFAULT NULL,
  `order_name` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `order_status` varchar(2) DEFAULT NULL,
  `data_state` varchar(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_order_info
-- ----------------------------
INSERT INTO `car_order_info` VALUES ('1', 'lirong', '北京', '石家庄', '2017-06-05 00:00:00', '13717111111', '李天', '2017-06-03 14:07:48', '0', '0');
INSERT INTO `car_order_info` VALUES (null, '', 'Anping', 'Shijiazhuang', '2017-06-05 00:07:53', '13717990661', null, '2017-06-05 00:07:53', null, null);

-- ----------------------------
-- Table structure for code_dic
-- ----------------------------
DROP TABLE IF EXISTS `code_dic`;
CREATE TABLE `code_dic` (
  `code_id` varchar(20) DEFAULT NULL,
  `code_name` varchar(100) DEFAULT NULL,
  `key` varchar(20) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `order` varchar(4) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_dic
-- ----------------------------
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', 'Shijiazhuang', '石家庄', '2');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', 'Beijing', '北京', '3');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', 'Bazhou', '霸州', '4');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', 'Hengshui', '衡水', '5');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', 'Baoding', '保定', '6');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', 'Tianjin', '天津', '7');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', 'Anping', '安平', '1');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', 'Beijing', '北京', '3');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', 'Bazhou', '霸州', '4');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', 'Hengshui', '衡水', '5');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', 'Baoding', '保定', '6');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', 'Tianjin', '天津', '7');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', 'Anping', '安平', '2');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', 'Shijiazhuang', '石家庄', '1');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-01 09:30:00', '2017-06-01 09:30', '12');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-01 10:00:00', '2017-06-01 10:00', '13');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-01 11:00:00', '2017-06-01 11:00', '14');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-01 12:00:00', '2017-06-01 12:00', '15');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-01 09:00:00', '2017-06-01 09:00', '11');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-02 09:00:00', '2017-06-02 09:00', '21');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-02 09:30:00', '2017-06-02 09:30', '22');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-02 10:00:00', '2017-06-02 10:00', '23');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-02 11:00:00', '2017-06-02 11:00', '24');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '2017-06-02 12:00:00', '2017-06-02 12:00', '25');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_no` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(20) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `head_img_url` varchar(1000) DEFAULT NULL,
  `privilege_List` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `id` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_no`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'lirong', 'Betteronly', '1', '中国', '北京', '北京', null, null, '李荣', '13717990661', '回龙观', '1111111111', '2017-06-04 22:51:58');
INSERT INTO `user_info` VALUES ('2', 'lirong1', 'Betteronly', '1', '中国', '北京', '北京', null, null, '李荣', '', '回龙观', '1111111111', '2017-06-04 22:51:19');
