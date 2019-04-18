package com.maxzuo.controller;

import com.alibaba.fastjson.JSONObject;
import com.maxzuo.form.Param;
import com.maxzuo.threadpool.cached.CachedThreadPool;
import com.maxzuo.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 店铺Rest
 * Created by zfh on 2019/01/19
 */
@RestController
@RequestMapping("/zxcity_restful/ws/shop")
public class ShopRest {

    private static final Logger logger = LoggerFactory.getLogger(ShopRest.class);

    private final ThreadPoolExecutor executor = new CachedThreadPool().getExecutor("一号机房");

    @PostMapping("findTradingGiftList")
    public Result findTradingGiftList(@RequestAttribute("param") Param param) {
        Result result = new Result(Result.RESULT_FAILURE, "系统繁忙！");
        JSONObject.parseObject(param.getData().toString());
        try {
            Future<String> orderResult = executor.submit(new PlaceOrderTask());
            Future<Integer> reduceResult = executor.submit(new ReduceInventory());

            // 阻塞结果的获取
            String order = orderResult.get();
            Integer reduce = reduceResult.get();

            Map<String, Object> data = new HashMap<>(16);
            data.put("order", order);
            data.put("reduce", reduce);
            result.setCode(Result.RESULT_SUCCESS);
            result.setMsg("查询成功");
            result.setData(data);
        } catch (Exception e) {
            logger.error("发生异常", e);
        }
        return result;
    }

    /**
     * 减库存任务
     */
    class ReduceInventory implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("start reduce inventory ... ");
            TimeUnit.SECONDS.sleep(2);
            return 1;
        }
    }

    /**
     * 订单任务
     */
    class PlaceOrderTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("start place order ...");
            TimeUnit.SECONDS.sleep(2);
            return LocalDateTime.now().toString();
        }
    }
}
