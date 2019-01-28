package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterKitchenDocumentTypeRules;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterKitchenDocumentTypeRulesServiceTest {

    @Autowired
    private IScShopPrinterKitchenDocumentTypeRulesService scShopPrinterKitchenDocumentTypeRulesService;

    @Transactional
    @Test
    public void save() {
        ScShopPrinterKitchenDocumentTypeRules documentTypeRules = new ScShopPrinterKitchenDocumentTypeRules();
        documentTypeRules.setPrinterKitchenId(1);
        documentTypeRules.setDocumentTypeId(1);
        documentTypeRules.setNumber(1);
        documentTypeRules.setPrinterType(1);
        documentTypeRules.setDelete(0);
        Integer affected = scShopPrinterKitchenDocumentTypeRulesService.save(documentTypeRules);
        Assert.assertTrue(affected > 0);
    }

    @Transactional
    @Test
    public void saveMultipleRecord() {
        List<ScShopPrinterKitchenDocumentTypeRules> documentTypeRulesList = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            ScShopPrinterKitchenDocumentTypeRules documentTypeRules = new ScShopPrinterKitchenDocumentTypeRules();
            documentTypeRules.setPrinterKitchenId(i);
            documentTypeRules.setDocumentTypeId(i);
            documentTypeRules.setNumber(1);
            documentTypeRules.setPrinterType(i);
            documentTypeRules.setDelete(0);
            documentTypeRulesList.add(documentTypeRules);
        }
        Integer affected = scShopPrinterKitchenDocumentTypeRulesService.saveMultipleRecord(documentTypeRulesList);
        Assert.assertTrue(affected > 5);
    }

    @Test
    public void listPrinterKitchenDocumentTypeRulesByPrinterKitchenId() {
        List<ScShopPrinterKitchenDocumentTypeRules> documentTypeRulesList = scShopPrinterKitchenDocumentTypeRulesService.listPrinterKitchenDocumentTypeRulesByPrinterKitchenId(1);
        Assert.assertEquals(documentTypeRulesList.size(), 2);
    }

    @Test
    public void selectByPrimaryKey() {
        ScShopPrinterKitchenDocumentTypeRules documentTypeRules = scShopPrinterKitchenDocumentTypeRulesService.selectByPrimaryKey(2);
        Assert.assertEquals(documentTypeRules.getId().longValue(), 2);
    }

    @Transactional
    @Test
    public void updateByPrimaryKeySelective() {
        ScShopPrinterKitchenDocumentTypeRules documentTypeRules = scShopPrinterKitchenDocumentTypeRulesService.selectByPrimaryKey(2);
        documentTypeRules.setDocumentTypeId(2);
        Integer integer = scShopPrinterKitchenDocumentTypeRulesService.updateByPrimaryKeySelective(documentTypeRules);
        Assert.assertTrue(integer > 0);
    }

    @Transactional
    @Test
    public void removeMultipleRecordByPrinterKitchenId() {
        Integer integer = scShopPrinterKitchenDocumentTypeRulesService.removeMultipleRecordByPrinterKitchenId(1);
        Assert.assertEquals(integer.longValue(), 2);
    }
}