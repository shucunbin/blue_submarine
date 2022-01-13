package io.blue.submarine.han.service;

import io.blue.submarine.han.core.shardingsphere.config.HintMaster;
import io.blue.submarine.han.core.model.order.Order;
import io.blue.submarine.han.core.model.order.OrderItem;
import io.blue.submarine.han.dao.mapper.order.OrderItemMapper;
import io.blue.submarine.han.dao.mapper.order.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单服务接口实现类.
 *
 * @author shucunbin
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public Order findByOrderId(Long orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    @HintMaster
    @Override
    public Order findByOrderIdFromMaster(Long orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    @Override
    public void save(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public void complexProcess() {
        System.out.println(batchSave());
    }

    @Override
    public Order findByUserId(Long userId) {
        return orderMapper.selectByUserId(userId);
    }

    private List<Long> batchSave() {
        List<Long> orderIdList = new ArrayList<>();
        for (long i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setUserId(i);
            order.setStatus("New");
            orderMapper.insert(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setUserId(i);
            orderItem.setStatus("New");
            orderItemMapper.insert(orderItem);
        }

        return orderIdList;
    }
}
