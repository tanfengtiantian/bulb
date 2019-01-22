package com.maxzuo.printtemplate.api;

import com.alibaba.fastjson.JSON;
import com.maxzuo.printtemplate.model.ScShopPrinterTemplateDocument;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IScShopPrinterTemplateDocumentServiceTest {

    @Autowired
    private IScShopPrinterTemplateDocumentService scShopPrinterTemplateDocumentService;

    @Test
    public void saveShopPrinterTemplateDocument() {
        ScShopPrinterTemplateDocument printerTemplateDocument = new ScShopPrinterTemplateDocument();
        printerTemplateDocument.setName("自定义模板");
        printerTemplateDocument.setDocumentType(1);
        printerTemplateDocument.setUrl("");
        printerTemplateDocument.setStatus(2);
        printerTemplateDocument.setShopId(288);
        printerTemplateDocument.setCreatorId(1);
        printerTemplateDocument.setCreatorName("dazuo");
        printerTemplateDocument.setCreateTime(new Date());
        Integer integer = scShopPrinterTemplateDocumentService.saveShopPrinterTemplateDocument(printerTemplateDocument);
        System.out.println("id: " + integer);
    }

    @Test
    public void getShopPrinterTemplateDocumentByPrimaryId() {
        ScShopPrinterTemplateDocument templateDocument = scShopPrinterTemplateDocumentService.getShopPrinterTemplateDocumentByPrimaryId(1);
        Assert.assertEquals(templateDocument.getName(), "系统模板-结账单");
    }

    @Test
    public void updateShopPrinterTemplateDocumentByPrimaryId() {
    }

    @Test
    public void listPrinterTemplateDocumentByShopIdAndDocumentType() {
        List<ScShopPrinterTemplateDocument> scShopPrinterTemplateDocuments = scShopPrinterTemplateDocumentService.listPrinterTemplateDocumentByShopIdAndDocumentType(0, 1);
        System.out.println("scShopPrinterTemplateDocuments: " + JSON.toJSON(scShopPrinterTemplateDocuments));
    }

}