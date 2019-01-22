package com.maxzuo.printtemplate.dao;

import com.maxzuo.printtemplate.model.ScShopPrinterKitchenGoodsRules;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 出票口配置打印菜品
 * Created by zfh on 2019/1/9
 */
@Mapper
public interface ScShopPrinterKitchenGoodsRulesMapper {

    /**
     * 新增记录
     * @param record {@link ScShopPrinterKitchenGoodsRules}
     * @return 自增主键
     */
    Integer insert(ScShopPrinterKitchenGoodsRules record);

    /**
     * 新增多条记录
     * @param recordList list
     * @return 受影响的条数
     */
    Integer insertMultipleRecord(List<ScShopPrinterKitchenGoodsRules> recordList);

    /**
     * 通过出票口ID 删除多条记录（软删除）
     * @param printerKitchenId 出票口ID
     * @return 受影响的条数
     */
    Integer updateMultipleRecordByPrinterKitchenId (Integer printerKitchenId);

    /**
     * 查询出票口 配置的打印菜品
     * @param printerKitchenId 出票口id
     * @return list
     */
    List<ScShopPrinterKitchenGoodsRules> selectPrinterKitchenGoodsRulesListByPrinterKitchenId(Integer printerKitchenId);

    /**
     * 根据主键查记录
     * @param id 主键
     * @return {@link ScShopPrinterKitchenGoodsRules}
     */
    ScShopPrinterKitchenGoodsRules selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新记录
     * @param record {@link ScShopPrinterKitchenGoodsRules}
     * @return 受影响的条数
     */
    Integer updateByPrimaryKeySelective(ScShopPrinterKitchenGoodsRules record);
}