package com.maxzuo.bulb.api;

import com.maxzuo.bulb.model.OrderItem;

/**
 * 订单详情相关Service
 * Created by zfh on 2019/01/19
 */
public interface IOrderItemService {

    /**
     * 添加记录
     * @param record {@link OrderItem}
     * @return 自增主键
     */
    Integer save(OrderItem record);

    /**
     * 通过主键查询记录
     * @param id 主键
     * @return {@link OrderItem}
     */
    OrderItem getByPrimaryKey (Integer id);

    /**
     * 更新记录
     * @param record {@link OrderItem}
     * @return 受影响的条数
     */
    Integer updateByPrimarySeletive (OrderItem record);

    /**
     * 删除记录
     * @param id 主键
     * @return 受影响的条数
     */
    Integer deleteByPrimaryKey (Integer id);
}
