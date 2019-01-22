package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterKitchenTableRules;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterKitchenTableRulesServiceTest {

    @Autowired
    private IScShopPrinterKitchenTableRulesService scShopPrinterKitchenTableRulesService;

    @Test
    public void save() {
        ScShopPrinterKitchenTableRules scShopPrinterKitchenTableRules = new ScShopPrinterKitchenTableRules();
        scShopPrinterKitchenTableRules.setPrinterKitchenId(1);
        scShopPrinterKitchenTableRules.setTableId(1);
        scShopPrinterKitchenTableRules.setDelete(0);
        Integer affected = scShopPrinterKitchenTableRulesService.save(scShopPrinterKitchenTableRules);
        Assert.assertTrue(affected > 0);
    }

    @Test
    public void saveMultipleRecord() {
        List<ScShopPrinterKitchenTableRules> kitchenTableRulesList = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            ScShopPrinterKitchenTableRules scShopPrinterKitchenTableRules = new ScShopPrinterKitchenTableRules();
            scShopPrinterKitchenTableRules.setPrinterKitchenId(i);
            scShopPrinterKitchenTableRules.setTableId(1);
            scShopPrinterKitchenTableRules.setDelete(0);
            kitchenTableRulesList.add(scShopPrinterKitchenTableRules);
        }
        Integer integer = scShopPrinterKitchenTableRulesService.saveMultipleRecord(kitchenTableRulesList);
        Assert.assertEquals(integer.longValue(), 5);
    }

    @Test
    public void listPrinterKitchenTableRulesByPrinterKitchenId() {
        List<ScShopPrinterKitchenTableRules> kitchenTableRulesList = scShopPrinterKitchenTableRulesService.listPrinterKitchenTableRulesByPrinterKitchenId(1);
        Assert.assertEquals(kitchenTableRulesList.size(), 2);
    }

    @Test
    public void getByPrimaryKey() {
        ScShopPrinterKitchenTableRules kitchenTableRules = scShopPrinterKitchenTableRulesService.getByPrimaryKey(2);
        Assert.assertEquals(kitchenTableRules.getId().longValue(), 2);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        ScShopPrinterKitchenTableRules kitchenTableRules = scShopPrinterKitchenTableRulesService.getByPrimaryKey(2);
        kitchenTableRules.setPrinterKitchenId(3);
        Integer integer = scShopPrinterKitchenTableRulesService.updateByPrimaryKeySelective(kitchenTableRules);
        Assert.assertTrue(integer > 0);
    }

    @Test
    public void removeMultipleRecordByPrinterKitchenId() {
        Integer integer = scShopPrinterKitchenTableRulesService.removeMultipleRecordByPrinterKitchenId(3);
        Assert.assertEquals(integer.longValue(), 2);
    }
}