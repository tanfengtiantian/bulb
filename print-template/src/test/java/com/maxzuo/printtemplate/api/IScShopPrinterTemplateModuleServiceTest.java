package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterTemplateModule;
import com.maxzuo.printtemplate.service.ScShopPrinterTemplateModuleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterTemplateModuleServiceTest {

    @Autowired
    private ScShopPrinterTemplateModuleServiceImpl scShopPrinterTemplateModuleService;

    @Test
    public void listPrinterTemplateModuleByDocumentId() {
        List<ScShopPrinterTemplateModule> moduleList = scShopPrinterTemplateModuleService.listPrinterTemplateModuleByDocumentId(1);
        Assert.assertEquals(moduleList.size(), 8);
    }
}