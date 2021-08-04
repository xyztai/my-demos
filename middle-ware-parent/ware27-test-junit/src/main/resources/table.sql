CREATE TABLE `jt_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_title` varchar(100) DEFAULT NULL COMMENT '活动主题',
  `contact_phone` varchar(15) NOT NULL COMMENT '联系号码',
  `is_online` int(1) NOT NULL DEFAULT '1' COMMENT '1线上、2线下',
  `address` varchar(200) DEFAULT NULL COMMENT '举办地址',
  `organizer` varchar(200) NOT NULL COMMENT '主办单位',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动信息表';

INSERT INTO `junit_test`.`jt_activity`(`id`, `activity_title`, `contact_phone`, `is_online`, `address`, `organizer`, `create_time`) VALUES (1, '618活动', '18967899876', 1, '上海市徐家汇1号路', '电商之都', '2021-05-26 12:47:11');
