-- 模拟主库
use
db_user_slave1;
CREATE TABLE `t_user`
(
    `id`      bigint unsigned NOT NULL AUTO_INCREMENT,
    `user_id` int NOT NULL,
    `name`    varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 模拟从库
use
db_user_slave0;
CREATE TABLE `t_user`
(
    `id`      bigint unsigned NOT NULL AUTO_INCREMENT,
    `user_id` int NOT NULL,
    `name`    varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;