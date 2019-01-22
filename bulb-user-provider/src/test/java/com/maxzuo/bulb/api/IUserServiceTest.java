package com.maxzuo.bulb.api;

import com.alibaba.fastjson.JSON;
import com.maxzuo.bulb.exception.BaseException;
import com.maxzuo.bulb.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("UserService的测试")
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-context.xml")
class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Transactional
    @Test
    void save() {
        User user = new User();
        user.setUsername("dazuo");
        user.setPassword("dazuo.123");
        Integer recordId = userService.save(user);
        assertTrue(recordId > 0);
    }

    @Transactional
    @Test
    void deleteByPrimaryKey() {
        Integer affected = userService.deleteByPrimaryKey(3);
        assertEquals(affected.longValue(), 1);
    }

    @Test
    void getByPrimaryKey() {
        User userInfo = userService.getByPrimaryKey(3);
        assertEquals(userInfo.getId().longValue(), 3);
    }

    @Test
    void updateByPrimaryKeySelective() {
        User userInfo = userService.getByPrimaryKey(3);
        System.out.println("userInfo: " + JSON.toJSON(userInfo));
        Integer count = userService.updateByPrimaryKeySelective(userInfo);
        assertEquals(count.longValue(), 1);
    }
}