package com.maxzuo.printtemplate.dao;

import com.maxzuo.printtemplate.model.ScShopPrinterKitchen;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 出票口相关Mapper
 * Created by zfh on 2019/1/9
 */
@Mapper
public interface ScShopPrinterKitchenMapper {

    /**
     * 添加记录
     * @param record {@link ScShopPrinterKitchen}
     * @return 自增主键
     */
    Integer insert(ScShopPrinterKitchen record);

    /**
     * 根据主键查询
     * @param id 主键
     * @return {@link ScShopPrinterKitchen}
     */
    ScShopPrinterKitchen selectByPrimaryKey(Integer id);

    /**
     * 查询店铺下所有的出票口（未删除）
     * @param shopId 店铺id
     * @return list
     */
    List<ScShopPrinterKitchen> selectPrinterKitchenListByShopId (Integer shopId);

    /**
     * 根据主键有选择性的更新
     * @param record {@link ScShopPrinterKitchen}
     * @return 受影响的条数
     */
    Integer updateByPrimaryKeySelective(ScShopPrinterKitchen record);
}