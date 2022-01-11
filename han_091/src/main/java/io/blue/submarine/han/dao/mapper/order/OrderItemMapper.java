package io.blue.submarine.han.dao.mapper.order;

import io.blue.submarine.han.core.model.order.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单明细 Mapper.
 *
 * @author shucunbin
 */
@Mapper
public interface OrderItemMapper {
    OrderItem findByOrderId(Long orderId);

    void insert(OrderItem orderItem);
}
