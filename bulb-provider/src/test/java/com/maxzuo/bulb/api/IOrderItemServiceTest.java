package com.maxzuo.bulb.api;

import com.maxzuo.bulb.model.OrderItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class IOrderItemServiceTest {

    @Autowired
    private IOrderItemService orderItemService;

    @Test
    public void save() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderNo("123");
        orderItem.setPrice(new BigDecimal("100"));
        orderItem.setProductId(1);
        orderItem.setUserId(3);
        Integer id = orderItemService.save(orderItem);
        Assert.assertTrue(id > 0);
    }
}
