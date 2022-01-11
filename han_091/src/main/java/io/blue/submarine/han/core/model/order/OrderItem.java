package io.blue.submarine.han.core.model.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 订单明细.
 *
 * @author shucunbin
 */
@Getter
@Setter
@ToString
public class OrderItem {
    private Long orderItemId;
    private Long orderId;
    private Long userId;
    private String status;
}
