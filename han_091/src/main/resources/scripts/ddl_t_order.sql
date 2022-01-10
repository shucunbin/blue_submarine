-- 模拟主库
use db_order_master;
CREATE TABLE `t_order_0`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_1`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_2`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- 模拟从库0
use db_order_slave0;
CREATE TABLE `t_order_0`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_1`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_2`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- 模拟从库1
use db_order_slave1;
CREATE TABLE `t_order_0`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_1`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_2`
(
    `id`       bigint unsigned NOT NULL,
    `order_id` int             NOT NULL,
    `user_id`  int         DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


