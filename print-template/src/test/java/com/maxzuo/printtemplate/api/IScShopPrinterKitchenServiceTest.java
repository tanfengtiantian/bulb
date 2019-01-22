package com.maxzuo.printtemplate.api;

import com.github.pagehelper.PageInfo;
import com.maxzuo.printtemplate.model.ScShopPrinterKitchen;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterKitchenServiceTest {

    @Autowired
    private IScShopPrinterKitchenService scShopPrinterKitchenService;

    @Test
    public void save() {
        ScShopPrinterKitchen printerKitchen = new ScShopPrinterKitchen();
        printerKitchen.setName("一号口");
        printerKitchen.setPrinterDeviceId(1);
        printerKitchen.setTable(0);
        printerKitchen.setGoods(0);
        printerKitchen.setDelete(0);
        printerKitchen.setShopId(288);
        printerKitchen.setCreatorId(1);
        printerKitchen.setCreatorName("dazuo");
        printerKitchen.setUpdatorId(1);
        printerKitchen.setUpdatorName("dazuo");
        Integer id = scShopPrinterKitchenService.save(printerKitchen);
        Assert.assertTrue(id > 0);
    }

    @Test
    public void getByPrimaryKey() {
        ScShopPrinterKitchen printerKitchen = scShopPrinterKitchenService.getByPrimaryKey(1);
        Assert.assertEquals(printerKitchen.getId().longValue(), 1);
    }

    @Test
    public void listPrinterKitchenByShopId() {
        PageInfo<ScShopPrinterKitchen> printerKitchenPageInfo = scShopPrinterKitchenService.listPrinterKitchenByShopId(288, 2, 1);
        Assert.assertEquals(printerKitchenPageInfo.getList().size(), 1);
        Assert.assertEquals(printerKitchenPageInfo.getList().get(0).getId().longValue(), 2);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        ScShopPrinterKitchen printerKitchen = scShopPrinterKitchenService.getByPrimaryKey(1);
        printerKitchen.setGoods(1);
        Integer integer = scShopPrinterKitchenService.updateByPrimaryKeySelective(printerKitchen);
        Assert.assertTrue(integer > 0);
    }
}