package com.maxzuo.bulb.api;

import com.maxzuo.bulb.model.ShopOrderInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@DisplayName("ShopOrderInfoService测试类")
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-context.xml")
class IShopOrderInfoServiceTest {

    @Autowired
    private IShopOrderInfoService shopOrderInfoService;

    @Transactional
    @Test
    void save() {
        ShopOrderInfo shopOrderInfo = new ShopOrderInfo();
        shopOrderInfo.setOrderNo("12345");
        shopOrderInfo.setUsername("dazuo");
        shopOrderInfo.setCount(1);
        Integer id = shopOrderInfoService.save(shopOrderInfo);
        Assertions.assertTrue(id > 0);
    }

    @Test
    void getShopOrderInfoByPrimaryKey() {
        ShopOrderInfo shopOrderInfo = shopOrderInfoService.getShopOrderInfoByPrimaryKey(1);
        Assertions.assertEquals(shopOrderInfo.getId().longValue(), 1);
    }

    @Test
    void updateByPrimarySeletive() {
        ShopOrderInfo shopOrderInfo = shopOrderInfoService.getShopOrderInfoByPrimaryKey(1);
        Integer affected = shopOrderInfoService.updateByPrimarySeletive(shopOrderInfo);
        Assertions.assertEquals(affected.longValue(), 1);
    }

    @Transactional
    @Test
    void deleteByPrimaryKey() {
        Integer affected = shopOrderInfoService.deleteByPrimaryKey(1);
        Assertions.assertEquals(affected.longValue(), 1);
    }
}
