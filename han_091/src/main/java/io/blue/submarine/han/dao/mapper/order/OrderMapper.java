package io.blue.submarine.han.dao.mapper.order;

import io.blue.submarine.han.core.model.order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单 mapper.
 *
 * @author shucunbin
 */
@Mapper
public interface OrderMapper {

    int insert(Order order);

    Order findByOrderId(@Param("order_id") Integer orderId);
}
