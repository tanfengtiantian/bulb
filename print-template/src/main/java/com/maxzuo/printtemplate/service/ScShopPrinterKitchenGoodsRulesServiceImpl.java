package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterKitchenGoodsRulesService;
import com.maxzuo.printtemplate.dao.ScShopPrinterKitchenGoodsRulesMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterKitchenGoodsRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出票口配置打印菜品相关Service实现类
 * Created by zfh on 2019/01/09
 */
@Service("scShopPrinterKitchenGoodsRulesService")
public class ScShopPrinterKitchenGoodsRulesServiceImpl implements IScShopPrinterKitchenGoodsRulesService {

    @Autowired
    private ScShopPrinterKitchenGoodsRulesMapper scShopPrinterKitchenGoodsRulesMapper;

    @Override
    public Integer save(ScShopPrinterKitchenGoodsRules record) {
        scShopPrinterKitchenGoodsRulesMapper.insert(record);
        return record.getId();
    }

    @Override
    public Integer saveMultipleRecord(List<ScShopPrinterKitchenGoodsRules> recordList) {
        return scShopPrinterKitchenGoodsRulesMapper.insertMultipleRecord(recordList);
    }

    @Override
    public Integer removeMultipleRecordByPrinterKitchenId(Integer printerKitchenId) {
        return scShopPrinterKitchenGoodsRulesMapper.updateMultipleRecordByPrinterKitchenId(printerKitchenId);
    }

    @Override
    public List<ScShopPrinterKitchenGoodsRules> listPrinterKitchenGoodsRulesByPrinterKitchenId(Integer printerKitchenId) {
        return scShopPrinterKitchenGoodsRulesMapper.selectPrinterKitchenGoodsRulesListByPrinterKitchenId(printerKitchenId);
    }

    @Override
    public ScShopPrinterKitchenGoodsRules getByPrimaryKey(Integer id) {
        return scShopPrinterKitchenGoodsRulesMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(ScShopPrinterKitchenGoodsRules record) {
        return scShopPrinterKitchenGoodsRulesMapper.updateByPrimaryKeySelective(record);
    }
}
