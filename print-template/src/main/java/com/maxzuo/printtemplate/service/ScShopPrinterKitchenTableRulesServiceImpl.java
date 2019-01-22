package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterKitchenTableRulesService;
import com.maxzuo.printtemplate.dao.ScShopPrinterKitchenTableRulesMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterKitchenTableRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出票口配置桌台区域相关Service实现类
 * Created by zfh on 2019/01/09
 */
@Service("scShopPrinterKitchenTableRulesService")
public class ScShopPrinterKitchenTableRulesServiceImpl implements IScShopPrinterKitchenTableRulesService {

    @Autowired
    private ScShopPrinterKitchenTableRulesMapper scShopPrinterKitchenTableRulesMapper;

    @Override
    public Integer save(ScShopPrinterKitchenTableRules record) {
        scShopPrinterKitchenTableRulesMapper.insert(record);
        return record.getId();
    }

    @Override
    public Integer saveMultipleRecord(List<ScShopPrinterKitchenTableRules> recordList) {
        return scShopPrinterKitchenTableRulesMapper.insertMultipleRecord(recordList);
    }

    @Override
    public Integer removeMultipleRecordByPrinterKitchenId(Integer printerKitchenId) {
        return scShopPrinterKitchenTableRulesMapper.updateMultipleRecordByPrinterKitchenId(printerKitchenId);
    }

    @Override
    public List<ScShopPrinterKitchenTableRules> listPrinterKitchenTableRulesByPrinterKitchenId(Integer printerKitchenId) {
        return scShopPrinterKitchenTableRulesMapper.selectPrinterKitchenTableRulesListByPrinterKitchenId(printerKitchenId);
    }

    @Override
    public ScShopPrinterKitchenTableRules getByPrimaryKey(Integer id) {
        return scShopPrinterKitchenTableRulesMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(ScShopPrinterKitchenTableRules record) {
        return scShopPrinterKitchenTableRulesMapper.updateByPrimaryKeySelective(record);
    }
}
