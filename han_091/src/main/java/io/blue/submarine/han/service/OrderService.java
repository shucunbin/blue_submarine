package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.order.Order;

/**
 * 订单服务接口.
 *
 * @author shucunbin
 */
public interface OrderService {
    Order findByOrderId(Long orderId);

    Order findByOrderIdFromMaster(Long orderId);

    void save(Order order);

    void complexProcess();

    Order findByUserId(Long userId);
}
