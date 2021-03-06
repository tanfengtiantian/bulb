package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScOperationPrinterSystemComponent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScOperationPrinterSystemComponentServiceTest {

    @Autowired
    private IScOperationPrinterSystemComponentService scOperationPrinterSystemComponentService;

    @Transactional
    @Test
    public void savePrinterSystemComponent () {
        // TODO:
    }

    @Test
    public void listPrinterSystemComponentByTemplateType() {
        List<ScOperationPrinterSystemComponent> systemComponentList = scOperationPrinterSystemComponentService.listPrinterSystemComponentByTemplateType(1);
        Assert.assertEquals(systemComponentList.size(), 151);
    }
}