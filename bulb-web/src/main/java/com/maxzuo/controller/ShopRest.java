package com.maxzuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.maxzuo.bulb.api.IShopOrderInfoService;
import com.maxzuo.form.Param;
import com.maxzuo.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 店铺Rest
 * Created by zfh on 2019/01/19
 */
@RestController
@RequestMapping("/zxcity_restful/ws/shop")
public class ShopRest {

    private static final Logger logger = LoggerFactory.getLogger(ShopRest.class);

    @Autowired
    private IShopOrderInfoService shopOrderInfoService;

    @PostMapping("findTradingGiftList")
    public Result findTradingGiftList(@RequestAttribute("param") Param param) {
        JSONObject jsonObject = JSONObject.parseObject(param.getData().toString());
        Integer shopId = jsonObject.getInteger("shopId");
        try {
            shopOrderInfoService.getShopOrderInfoByPrimaryKey(shopId);
        } catch (Exception e) {
            logger.error("发生异常", e);
        }
        return new Result(Result.RESULT_SUCCESS, "ok");
    }
}
