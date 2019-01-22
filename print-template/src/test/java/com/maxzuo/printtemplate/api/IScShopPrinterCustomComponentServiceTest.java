package com.maxzuo.printtemplate.api;

import com.alibaba.fastjson.JSON;
import com.maxzuo.printtemplate.model.ScShopPrinterCustomComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterCustomComponentServiceTest {

    @Autowired
    private IScShopPrinterCustomComponentService scShopPrinterCustomComponentService;

    @Test
    public void saveMultiplePrinterCustomComponent() {
        List<ScShopPrinterCustomComponent> customComponentList = new ArrayList(10);
        for (int i = 0; i < 3; i++) {
            ScShopPrinterCustomComponent customComponent = new ScShopPrinterCustomComponent();
            customComponent.setDocumentTemplateId(1);
            customComponent.setSystemComponentId(i);
            customComponent.setValueStyle("css");
            customComponentList.add(customComponent);
        }
        Integer count = scShopPrinterCustomComponentService.saveMultiplePrinterCustomComponent(customComponentList);
        System.out.println("count：" + count);
    }

    @Test
    public void listPrinterTemplateCustomComponentByTemplateId() {
        List<ScShopPrinterCustomComponent> scShopPrinterCustomComponents = scShopPrinterCustomComponentService.listPrinterTemplateCustomComponentByTemplateId(1);
        System.out.println("json: " + JSON.toJSON(scShopPrinterCustomComponents));
        Assert.assertEquals(scShopPrinterCustomComponents.size(), 151);
    }
}