package com.maxzuo.bulb.dao;

import com.maxzuo.bulb.model.OrderItem;

/**
 * 订单详情表相关Mapper
 * Created by zfh on 2019/01/18
 */
public interface OrderItemMapper {

    /**
     * 添加记录
     * @param record {@link OrderItem}
     * @return 自增主键
     */
    Integer insert(OrderItem record);

    /**
     * 通过主键查询记录
     * @param id 主键
     * @return {@link OrderItem}
     */
    OrderItem selectByPrimaryKey(Integer id);

    /**
     * 更新记录
     * @param record {@link OrderItem}
     * @return 受影响的条数
     */
    Integer updateByPrimarySeletive(OrderItem record);

    /**
     * 删除记录
     * @param id 主键
     * @return 受影响的条数
     */
    Integer deleteByPrimaryKey(Integer id);
}
