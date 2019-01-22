package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterSystemComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterSystemComponentServiceTest {

    @Autowired
    private IScShopPrinterSystemComponentService scShopPrinterSystemComponentService;

    @Test
    public void savePrinterSystemComponent () {
        // TODO:
    }

    @Test
    public void listPrinterSystemComponentByTemplateType() {
        List<ScShopPrinterSystemComponent> systemComponentList = scShopPrinterSystemComponentService.listPrinterSystemComponentByTemplateType(1);
        Assert.assertEquals(systemComponentList.size(), 151);
    }
}