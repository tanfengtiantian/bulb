package com.maxzuo.printtemplate.dao;

import com.maxzuo.printtemplate.model.ScShopPrinterKitchenDocumentTypeRules;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 出票口票据类型相关Mapper
 * Created by zfh on 2019/1/9
 */
@Mapper
public interface ScShopPrinterKitchenDocumentTypeRulesMapper {

    /**
     * 新增记录
     * @param record {@link ScShopPrinterKitchenDocumentTypeRules}
     * @return 自增主键
     */
    Integer insert(ScShopPrinterKitchenDocumentTypeRules record);

    /**
     * 添加多条记录
     * @param documentTypeRulesList list
     * @return 受影响的条数
     */
    Integer insertMultipleRecord (List<ScShopPrinterKitchenDocumentTypeRules> documentTypeRulesList);

    /**
     * 根据 出票口ID 删除多条记录（软删除）
     * @param printerKitchenId 出票口ID
     * @return 受影响的条数
     */
    Integer updateMultipleRecordByPrinterKitchenId (Integer printerKitchenId);

    /**
     * 查询 出票口 票据类型
     * @param printerKitchenId 出票口id
     * @return list
     */
    List<ScShopPrinterKitchenDocumentTypeRules> selectPrinterKitchenDocumentTypeRulesListByPrinterKitchenId(Integer printerKitchenId);

    /**
     * 根据主键查记录
     * @param id 主键
     * @return {@link ScShopPrinterKitchenDocumentTypeRules}
     */
    ScShopPrinterKitchenDocumentTypeRules selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新记录
     * @param record {@link ScShopPrinterKitchenDocumentTypeRules}
     * @return 受影响的条数
     */
    Integer updateByPrimaryKeySelective(ScShopPrinterKitchenDocumentTypeRules record);
}