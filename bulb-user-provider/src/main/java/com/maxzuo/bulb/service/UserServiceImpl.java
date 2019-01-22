package com.maxzuo.bulb.service;

import com.maxzuo.bulb.api.IUserService;
import com.maxzuo.bulb.dao.UserMapper;
import com.maxzuo.bulb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user相关Service实现类
 * Created by MAX_zuo on 2018/09/15
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer save(User record) {
        userMapper.insert(record);
        return record.getId();
    }

    @Override
    public User getByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }
}
