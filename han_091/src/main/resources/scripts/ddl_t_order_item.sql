-- 模拟主库
use db_order_master;
CREATE TABLE `t_order_item_0`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_item_1`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_item_2`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- 模拟从库0
use db_order_slave0;
CREATE TABLE `t_order_item_0`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_item_1`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_item_2`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- 模拟从库1
use db_order_slave1;
CREATE TABLE `t_order_item_0`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_item_1`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `t_order_item_2`
(
    `order_item_id` bigint NOT NULL,
    `order_id`      bigint NOT NULL,
    `user_id`       bigint      DEFAULT NULL,
    `status`        varchar(32) DEFAULT NULL,
    PRIMARY KEY (`order_item_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;