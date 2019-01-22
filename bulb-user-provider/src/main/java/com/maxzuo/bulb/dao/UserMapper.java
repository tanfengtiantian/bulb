package com.maxzuo.bulb.dao;

import com.maxzuo.bulb.model.User;

/**
 * 用户表相关Mapper
 * Created by zfh on 2018/10/09
 */
public interface UserMapper {

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
    Integer insert(User record);

    /**
     * 根据主键查询用户
     * @param id 主键
     * @return {@link User}
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 更新记录
     * @param record {@link User}
     * @return 受影响的条数
     */
    Integer updateByPrimaryKeySelective(User record);
}
