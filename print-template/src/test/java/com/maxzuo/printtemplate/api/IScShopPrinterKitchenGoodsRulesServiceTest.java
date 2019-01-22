package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterKitchenGoodsRules;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterKitchenGoodsRulesServiceTest {

    @Autowired
    private IScShopPrinterKitchenGoodsRulesService scShopPrinterKitchenGoodsRulesService;

    @Test
    public void save() {
        ScShopPrinterKitchenGoodsRules printerKitchenGoodsRules = new ScShopPrinterKitchenGoodsRules();
        printerKitchenGoodsRules.setPrinterKitchenId(1);
        printerKitchenGoodsRules.setGoodsId(1);
        printerKitchenGoodsRules.setStockId(1);
        printerKitchenGoodsRules.setDelete(0);
        Integer id = scShopPrinterKitchenGoodsRulesService.save(printerKitchenGoodsRules);
        Assert.assertTrue(id > 0);
    }

    @Test
    public void saveMultipleRecord() {
        List<ScShopPrinterKitchenGoodsRules> printerKitchenGoodsRulesList = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            ScShopPrinterKitchenGoodsRules printerKitchenGoodsRules = new ScShopPrinterKitchenGoodsRules();
            printerKitchenGoodsRules.setPrinterKitchenId(i);
            printerKitchenGoodsRules.setGoodsId(i);
            printerKitchenGoodsRules.setStockId(i);
            printerKitchenGoodsRules.setDelete(0);
            printerKitchenGoodsRulesList.add(printerKitchenGoodsRules);
        }
        Integer integer = scShopPrinterKitchenGoodsRulesService.saveMultipleRecord(printerKitchenGoodsRulesList);
        Assert.assertEquals(integer.longValue(), 5);
    }

    @Test
    public void listPrinterKitchenGoodsRulesByPrinterKitchenId() {
        List<ScShopPrinterKitchenGoodsRules> printerKitchenGoodsRulesList = scShopPrinterKitchenGoodsRulesService.listPrinterKitchenGoodsRulesByPrinterKitchenId(1);
        Assert.assertEquals(printerKitchenGoodsRulesList.size(), 2);
    }

    @Test
    public void getByPrimaryKey() {
        ScShopPrinterKitchenGoodsRules kitchenGoodsRules = scShopPrinterKitchenGoodsRulesService.getByPrimaryKey(2);
        Assert.assertEquals(kitchenGoodsRules.getId().longValue(), 2);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        ScShopPrinterKitchenGoodsRules kitchenGoodsRules = scShopPrinterKitchenGoodsRulesService.getByPrimaryKey(2);
        kitchenGoodsRules.setGoodsId(2);
        Integer integer = scShopPrinterKitchenGoodsRulesService.updateByPrimaryKeySelective(kitchenGoodsRules);
        Assert.assertTrue(integer > 0);
    }

    @Test
    public void removeMultipleRecordByPrinterKitchenId() {
        Integer integer = scShopPrinterKitchenGoodsRulesService.removeMultipleRecordByPrinterKitchenId(1);
        Assert.assertEquals(integer.longValue(), 2);
    }
}