package com.maxzuo.printtemplate.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.maxzuo.printtemplate.model.ScShopPrinterDevice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterDeviceServiceTest {

    @Autowired
    private IScShopPrinterDeviceService scShopPrinterDeviceService;

    @Test
    public void save() {
        ScShopPrinterDevice scShopPrinterDevice = new ScShopPrinterDevice();
        scShopPrinterDevice.setDeviceName("一号机");
        scShopPrinterDevice.setPrinterDeviceType(1);
        scShopPrinterDevice.setAddress("127.0.0.3");
        scShopPrinterDevice.setDelete(0);
        scShopPrinterDevice.setShopId(288);
        scShopPrinterDevice.setCreatorId(1);
        scShopPrinterDevice.setCreatorName("dazuo");
        scShopPrinterDevice.setUpdatorId(1);
        scShopPrinterDevice.setUpdatorName("dazuo");
        Integer id = scShopPrinterDeviceService.save(scShopPrinterDevice);
        Assert.assertTrue(id > 0);
    }

    @Test
    public void getScShopPrinterDeviceByPrimaryKey() {
        ScShopPrinterDevice printerDevice = scShopPrinterDeviceService.getScShopPrinterDeviceByPrimaryKey(1);
        System.out.println(JSONObject.toJSON(printerDevice));
        Assert.assertNotNull(printerDevice);
    }

    @Test
    public void listPrinterDeviceByShopId () {
        PageInfo<ScShopPrinterDevice> pageInfo = scShopPrinterDeviceService.listPrinterDeviceByShopId(288, 2, 1);
        System.out.println(JSON.toJSON(pageInfo));
        Assert.assertEquals(pageInfo.getList().size(), 1);
        Assert.assertEquals(pageInfo.getList().get(0).getAddress(), "127.0.0.3");
    }

    @Test
    public void updateByPrimaryKeySelective() {
        ScShopPrinterDevice printerDevice = scShopPrinterDeviceService.getScShopPrinterDeviceByPrimaryKey(1);
        printerDevice.setDelete(1);
        Integer integer = scShopPrinterDeviceService.updateByPrimaryKeySelective(printerDevice);
        Assert.assertTrue(integer > 0);
    }
}