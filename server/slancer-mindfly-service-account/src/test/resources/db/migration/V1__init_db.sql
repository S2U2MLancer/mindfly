
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` BIGINT(20) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `nick_name` VARCHAR(100) NOT NULL,
  `gender` int not NULL default 0,
  `birthday` DATETIME NULL,
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NULL,
  `delete_flag` tinyint DEFAULT 0 NOT NULL,
  PRIMARY KEY (`id`)
);

--CREATE TABLE IF NOT EXISTS `username_account` (
--  `user_id` BIGINT(20) UNSIGNED NOT NULL,
--  `username` VARCHAR(256) NOT NULL,
--  `password` VARCHAR(256) NOT NULL,
--  `create_time` DATETIME NOT NULL,
--  PRIMARY KEY (`user_id`),
--  UNIQUE KEY username_account_username (`username`)
--);

