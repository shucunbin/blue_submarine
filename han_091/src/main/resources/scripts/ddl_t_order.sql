DROP DATABASE IF EXISTS `db_order_master`;
DROP DATABASE IF EXISTS `db_order_slave0`;
DROP DATABASE IF EXISTS `db_order_0`;
DROP DATABASE IF EXISTS `db_order_1`;

CREATE DATABASE `db_order_master` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE DATABASE `db_order_slave0` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE DATABASE `db_order_slave1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE DATABASE `db_order_0` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE DATABASE `db_order_1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

-- 模拟主库
use db_order_master;
CREATE TABLE `t_order_0`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_1`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_2`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- 模拟从库0
use db_order_slave0;
CREATE TABLE `t_order_0`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_1`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_2`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- 模拟从库1
use db_order_slave1;
CREATE TABLE `t_order_0`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_1`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_2`
(
    `order_id` bigint NOT NULL,
    `user_id`  bigint      DEFAULT NULL,
    `status`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


