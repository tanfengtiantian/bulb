package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterKitchenDocumentTypeRulesService;
import com.maxzuo.printtemplate.dao.ScShopPrinterKitchenDocumentTypeRulesMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterKitchenDocumentTypeRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出票口票据类型相关Service实现类
 * Created by zfh on 2019/01/09
 */
@Service("scShopPrinterKitchenDocumentTypeRulesService")
public class ScShopPrinterKitchenDocumentTypeRulesServiceImpl implements IScShopPrinterKitchenDocumentTypeRulesService {

    @Autowired
    private ScShopPrinterKitchenDocumentTypeRulesMapper scShopPrinterKitchenDocumentTypeRulesMapper;

    @Override
    public Integer save(ScShopPrinterKitchenDocumentTypeRules record) {
        scShopPrinterKitchenDocumentTypeRulesMapper.insert(record);
        return record.getId();
    }

    @Override
    public Integer saveMultipleRecord(List<ScShopPrinterKitchenDocumentTypeRules> recordList) {
        return scShopPrinterKitchenDocumentTypeRulesMapper.insertMultipleRecord(recordList);
    }

    @Override
    public Integer removeMultipleRecordByPrinterKitchenId(Integer printerKitchenId) {
        return scShopPrinterKitchenDocumentTypeRulesMapper.updateMultipleRecordByPrinterKitchenId(printerKitchenId);
    }

    @Override
    public List<ScShopPrinterKitchenDocumentTypeRules> listPrinterKitchenDocumentTypeRulesByPrinterKitchenId(Integer printerKitchenId) {
        return scShopPrinterKitchenDocumentTypeRulesMapper.selectPrinterKitchenDocumentTypeRulesListByPrinterKitchenId(printerKitchenId);
    }

    @Override
    public ScShopPrinterKitchenDocumentTypeRules selectByPrimaryKey(Integer id) {
        return scShopPrinterKitchenDocumentTypeRulesMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(ScShopPrinterKitchenDocumentTypeRules record) {
        return scShopPrinterKitchenDocumentTypeRulesMapper.updateByPrimaryKeySelective(record);
    }
}
