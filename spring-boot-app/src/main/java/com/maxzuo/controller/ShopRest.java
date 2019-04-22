package com.maxzuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.maxzuo.form.Param;
import com.maxzuo.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 店铺Rest
 * Created by zfh on 2019/01/19
 */
@RestController
@RequestMapping("/zxcity_restful/ws/shop")
public class ShopRest {

    private static final Logger logger = LoggerFactory.getLogger(ShopRest.class);

    @PostMapping("findTradingGiftList")
    public Result findTradingGiftList(@RequestAttribute("param") Param param) {
        Result result = new Result(Result.RESULT_FAILURE, "系统繁忙！");
        JSONObject.parseObject(param.getData().toString());
        try {
            Map<String, Object> data = new HashMap<>(16);
            result.setCode(Result.RESULT_SUCCESS);
            result.setMsg("查询成功");
            result.setData(data);
        } catch (Exception e) {
            logger.error("发生异常", e);
        }
        return result;
    }
}
