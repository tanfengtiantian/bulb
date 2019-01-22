package com.maxzuo.bulb.service;

import com.maxzuo.bulb.dao.OrderItemMapper;
import com.maxzuo.bulb.api.IOrderItemService;
import com.maxzuo.bulb.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单详情相关Service实现类
 * Created by zfh on 2019/01/19
 */
@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public Integer save(OrderItem record) {
        orderItemMapper.insert(record);
        return record.getId();
    }

    @Override
    public OrderItem getByPrimaryKey(Integer id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimarySeletive(OrderItem record) {
        return orderItemMapper.updateByPrimarySeletive(record);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return orderItemMapper.deleteByPrimaryKey(id);
    }
}
