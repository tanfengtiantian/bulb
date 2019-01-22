package com.maxzuo.bulb.api;

import com.maxzuo.bulb.model.User;

import java.util.List;

/**
 * 用户相关Service
 * Created by MAX_zuo on 2018/09/15
 */
public interface IUserService {

    /**
     * 删除记录
     * @param id 主键
     * @return 受影响的条数
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 添加记录
     * @param record {@link User}
     * @return 自增主键
     */
    Integer save(User record);

    /**
     * 根据主键查询用户
     * @param id 主键
     * @return {@link User}
     */
    User getByPrimaryKey(Integer id);

    /**
     * 更新记录
     * @param record {@link User}
     * @return 受影响的条数
     */
    Integer updateByPrimaryKeySelective(User record);
}
