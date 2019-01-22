package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterKitchenTableRules;

import java.util.List;

/**
 * 出票口配置桌台区域相关Service
 * Created by zfh on 2019/01/09
 */
public interface IScShopPrinterKitchenTableRulesService {

    /**
     * 新增记录
     * @param record {@link ScShopPrinterKitchenTableRules}
     * @return 自增主键
     */
    Integer save(ScShopPrinterKitchenTableRules record);

    /**
     * 新增多条记录
     * @param recordList list
     * @return 受影响的条数
     */
    Integer saveMultipleRecord (List<ScShopPrinterKitchenTableRules> recordList);

    /**
     * 根据出票口 删除多条记录（软删除）
     * @param printerKitchenId 出票口ID
     * @return 受影响的条数
     */
    Integer removeMultipleRecordByPrinterKitchenId (Integer printerKitchenId);

    /**
     * 查询出票口配置的桌台区域
     * @param printerKitchenId 出票口id
     * @return list
     */
    List<ScShopPrinterKitchenTableRules> listPrinterKitchenTableRulesByPrinterKitchenId(Integer printerKitchenId);

    /**
     * 根据主键查询记录
     * @param id 主键
     * @return {@link ScShopPrinterKitchenTableRules}
     */
    ScShopPrinterKitchenTableRules getByPrimaryKey(Integer id);

    /**
     * 根据主键更新记录
     * @param record {@link ScShopPrinterKitchenTableRules}
     * @return 受影响的条数
     */
    Integer updateByPrimaryKeySelective(ScShopPrinterKitchenTableRules record);
}
