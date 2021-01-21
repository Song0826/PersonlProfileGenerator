/******************************************/
/*   DatabaseName = personalpagegengeratordb   */
/*   TableName = personalpagegengerator_edu   */
/******************************************/
CREATE TABLE `edu` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(20) DEFAULT NULL,
  `start` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `end` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `school` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `study` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `edu_userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC
;

/******************************************/
/*   DatabaseName = personalpagegengeratordb   */
/*   TableName = personalpagegengerator_skill   */
/******************************************/
CREATE TABLE `skill` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(20) DEFAULT NULL,
  `keywords` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `skill_userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8
;

/******************************************/
/*   DatabaseName = personalpagegengeratordb   */
/*   TableName = personalpagegengerator_specialty   */
/******************************************/
CREATE TABLE `specialty` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(20) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8
;

/******************************************/
/*   DatabaseName = personalpagegengeratordb   */
/*   TableName = personalpagegengerator_user   */
/******************************************/
CREATE TABLE `user` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `age` int(8) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `facebook` varchar(64) DEFAULT NULL,
  `linkedin` varchar(32) DEFAULT NULL,
  `twitter` varchar(256) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8
;

/******************************************/
/*   DatabaseName = personalpagegengeratordb   */
/*   TableName = personalpagegengerator_work   */
/******************************************/
CREATE TABLE `work` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(20) DEFAULT NULL,
  `start` varchar(64) DEFAULT NULL,
  `end` varchar(64) DEFAULT NULL,
  `company` varchar(64) DEFAULT NULL,
  `job` varchar(64) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8
;
