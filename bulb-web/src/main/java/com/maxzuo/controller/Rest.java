package com.maxzuo.controller;

import com.maxzuo.bulb.api.IShopOrderInfoService;
import com.maxzuo.bulb.model.ShopOrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zfh on 2018/09/19
 */
@RestController
public class Rest {

    @Autowired
    private IShopOrderInfoService shopOrderInfoService;

    @GetMapping("main")
    public String main() {
        try {
            ShopOrderInfo orderInfo = shopOrderInfoService.getShopOrderInfoByPrimaryKey(1);
            System.out.println("orderInfo: " + orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "main rest";
    }
}
