package io.blue.submarine.han.service;

import io.blue.submarine.han.core.model.order.Order;
import io.blue.submarine.han.dao.mapper.order.OrderMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单服务接口实现类.
 *
 * @author shucunbin
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order findByOrderId(Integer orderId) {
        return orderMapper.findByOrderId(orderId);
    }

    @Override
    public Order findByOrderIdFromMaster(Integer orderId) {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.setMasterRouteOnly();
            return orderMapper.findByOrderId(orderId);
        }
    }

    @Override
    public void save(Order order) {
        orderMapper.insert(order);
    }
}
