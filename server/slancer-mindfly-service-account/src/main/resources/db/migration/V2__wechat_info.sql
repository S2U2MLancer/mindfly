
--create database account_service default charset=utf8mb4;

CREATE TABLE IF NOT EXISTS `wechat_info` (
  `open_id` unsigned bigint(20)  NOT NULL,
  `user_id` unsigned bigint(20)  NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`open_id`)
) Engine=InnoDB default charset=utf8mb4;

--CREATE TABLE IF NOT EXISTS `username_account` (
--  `user_id` BIGINT(20) UNSIGNED NOT NULL,
--  `username` VARCHAR(256) NOT NULL,
--  `password` VARCHAR(256) NOT NULL,
--  `create_time` DATETIME NOT NULL,
--  PRIMARY KEY (`user_id`),
--  UNIQUE KEY username_account_username (`username`)
--) Engine=InnoDB default charset=utf8mb4;

