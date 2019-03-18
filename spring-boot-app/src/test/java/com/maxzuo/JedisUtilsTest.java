package com.maxzuo;

import com.maxzuo.redis.RedisUtils;
import org.junit.Test;

/**
 * Created by zfh on 2019/03/18
 */
public class JedisUtilsTest {

    @Test
    public void test () {
        RedisUtils.setStr("name", "dazuo");
        String name = RedisUtils.getStr("name");
        System.out.println(name);
    }
}
