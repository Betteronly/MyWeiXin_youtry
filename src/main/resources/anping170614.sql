/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : anping

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-06-12 00:02:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car_order_info
-- ----------------------------
DROP TABLE IF EXISTS `car_order_info`;
CREATE TABLE `car_order_info` (
  `car_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` varchar(20) DEFAULT NULL,
  `open_id` varchar(100) DEFAULT NULL,
  `addr_from` varchar(255) DEFAULT NULL,
  `addr_to` varchar(255) DEFAULT NULL,
  `depart_time` datetime DEFAULT NULL,
  `order_phone` varchar(20) DEFAULT NULL,
  `order_name` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `order_status` varchar(20) DEFAULT NULL,
  `data_state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`car_order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_order_info
-- ----------------------------
INSERT INTO `car_order_info` VALUES ('1', '1', 'lirong', '安平', '石家庄', '2017-06-11 17:57:13', '13717990661', '李天天', '2017-06-11 17:57:13', '订单作废', '0');

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
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', '石家庄', '石家庄', '2');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', '北京', '北京', '3');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', '德州', '德州', '4');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', '衡水', '衡水', '5');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', '保定', '保定', '6');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', '天津', '天津', '7');
INSERT INTO `code_dic` VALUES ('ADDR_FROM_LIST', '出发地列表', '安平', '安平', '1');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', '北京', '北京', '3');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', '德州', '德州', '4');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', '衡水', '衡水', '5');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', '保定', '保定', '6');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', '天津', '天津', '7');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', '安平', '安平', '2');
INSERT INTO `code_dic` VALUES ('ADDR_TO_LIST', '目的地列表', '石家庄', '石家庄', '1');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '05:00:00', '05:00', '050');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '05:30:00', '05:30', '053');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '06:00:00', '06:00', '060');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '06:30:00', '06:30', '063');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '07:00:00', '07:00', '070');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '07:30:00', '07:30', '073');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '08:00:00', '08:00', '080');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '08:30:00', '08:30', '083');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '09:00:00', '09:00', '090');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '09:30:00', '09:30', '093');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '10:00:00', '10:00', '100');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '10:30:00', '10:30', '103');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '11:00:00', '11:00', '110');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '11:30:00', '11:30', '113');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '12:00:00', '12:00', '120');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '12:30:00', '12:30', '123');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '13:00:00', '13:00', '130');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '13:30:00', '13:30', '133');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '14:00:00', '14:00', '140');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '14:30:00', '14:30', '143');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '15:30:00', '15:30', '153');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '15:30:00', '15:30', '153');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '16:00:00', '16:00', '160');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '16:30:00', '16:30', '163');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '17:00:00', '17:00', '170');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '17:30:00', '17:30', '173');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '18:00:00', '18:00', '180');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '18:30:00', '18:30', '183');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '19:00:00', '19:00', '190');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '19:30:00', '19:30', '193');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '20:00:00', '20:00', '200');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '20:30:00', '20:30', '203');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '21:00:00', '21:00', '210');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '21:30:00', '21:30', '213');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '22:00:00', '22:00', '220');
INSERT INTO `code_dic` VALUES ('DEPART_TIME_LIST', '出发时间 列表', '22:30:00', '22:30', '223');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '待确认', '待确认', '1');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '确认完毕', '确认完毕', '2');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '待约车', '待约车', '3');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '订单取消', '订单取消', '6');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '订单完成', '订单完成', '7');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '约车完毕', '约车完毕', '4');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '待出发', '待出发', '5');
INSERT INTO `code_dic` VALUES ('order_status', '约车信息状态', '订单作废', '订单作废', '8');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_no` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(100) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `head_Img_Url` varchar(1000) DEFAULT NULL,
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
INSERT INTO `user_info` VALUES ('1', 'lirong', '李天天', '1', '中国', '北京', '北京', null, null, '', '13717990661', '回龙观', '1111111111', '2017-06-10 01:32:03');
INSERT INTO `user_info` VALUES ('2', 'lirong1', 'Betteronly', '1', '中国', '北京', '北京', null, null, '李李李', '', '回龙观', '1111111111', '2017-06-10 01:31:40');
