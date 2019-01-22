package com.maxzuo.bulb.api;

import com.maxzuo.bulb.model.OrderItem;
import com.maxzuo.bulb.model.ShopOrderInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@DisplayName("订单详情Service测试类")
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-context.xml")
class IOrderItemServiceTest {

    @Autowired
    private IOrderItemService orderItemService;

    @Transactional
    @Test
    void save() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderNo("123");
        orderItem.setPrice(new BigDecimal("100"));
        orderItem.setProductId(1);
        orderItem.setUserId(3);
        Integer id = orderItemService.save(orderItem);
        Assertions.assertTrue(id > 0);
    }
}
