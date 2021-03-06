package com.maxzuo.printtemplate.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.maxzuo.printtemplate.model.ScOperationPrinterDevice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScOperationPrinterDeviceServiceTest {

    @Autowired
    private IScOperationPrinterDeviceService scOperationPrinterDeviceService;

    @Transactional
    @Test
    public void save() {
        ScOperationPrinterDevice scShopPrinterDevice = new ScOperationPrinterDevice();
        scShopPrinterDevice.setDeviceName("一号机");
        scShopPrinterDevice.setPrinterDeviceType(1);
        scShopPrinterDevice.setAddress("127.0.0.3");
        scShopPrinterDevice.setDelete(0);
        scShopPrinterDevice.setShopId(288);
        scShopPrinterDevice.setCreatorId(1);
        scShopPrinterDevice.setCreatorName("dazuo");
        scShopPrinterDevice.setUpdatorId(1);
        scShopPrinterDevice.setUpdatorName("dazuo");
        Integer id = scOperationPrinterDeviceService.save(scShopPrinterDevice);
        Assert.assertTrue(id > 0);
    }

    @Test
    public void getScShopPrinterDeviceByPrimaryKey() {
        ScOperationPrinterDevice printerDevice = scOperationPrinterDeviceService.getScShopPrinterDeviceByPrimaryKey(1);
        System.out.println(JSONObject.toJSON(printerDevice));
        Assert.assertNotNull(printerDevice);
    }

    @Test
    public void listPrinterDeviceByShopId () {
        PageInfo<ScOperationPrinterDevice> pageInfo = scOperationPrinterDeviceService.listPrinterDeviceByShopId(288, 2, 1);
        System.out.println(JSON.toJSON(pageInfo));
        Assert.assertEquals(pageInfo.getList().size(), 1);
        Assert.assertEquals(pageInfo.getList().get(0).getAddress(), "127.0.0.3");
    }

    @Transactional
    @Test
    public void updateByPrimaryKeySelective() {
        ScOperationPrinterDevice printerDevice = scOperationPrinterDeviceService.getScShopPrinterDeviceByPrimaryKey(1);
        printerDevice.setDelete(1);
        Integer integer = scOperationPrinterDeviceService.updateByPrimaryKeySelective(printerDevice);
        Assert.assertTrue(integer > 0);
    }
}