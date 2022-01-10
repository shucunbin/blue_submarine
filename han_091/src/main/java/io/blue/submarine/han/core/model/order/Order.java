package io.blue.submarine.han.core.model.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 订单信息.
 *
 * @author shucunbin
 * @date 2022-01-07 10:30
 */
@Getter
@Setter
@ToString
public class Order {
    private Long id;
    private Integer orderId;
    private Integer userId;
    private String status;
}
