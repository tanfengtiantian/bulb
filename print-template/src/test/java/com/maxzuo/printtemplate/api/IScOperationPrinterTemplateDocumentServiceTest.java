package com.maxzuo.printtemplate.api;

import com.alibaba.fastjson.JSON;
import com.maxzuo.printtemplate.model.ScOperationPrinterTemplateDocument;
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
public class IScOperationPrinterTemplateDocumentServiceTest {

    @Autowired
    private IScOperationPrinterTemplateDocumentService scOperationPrinterTemplateDocumentService;

    @Test
    public void saveShopPrinterTemplateDocument() {
        ScOperationPrinterTemplateDocument printerTemplateDocument = new ScOperationPrinterTemplateDocument();
        printerTemplateDocument.setName("自定义模板");
        printerTemplateDocument.setDocumentType(1);
        printerTemplateDocument.setUrl("");
        printerTemplateDocument.setStatus(2);
        printerTemplateDocument.setShopId(288);
        printerTemplateDocument.setCreatorId(1);
        printerTemplateDocument.setCreatorName("dazuo");
        printerTemplateDocument.setCreateTime(new Date());
        Integer integer = scOperationPrinterTemplateDocumentService.saveShopPrinterTemplateDocument(printerTemplateDocument);
        System.out.println("id: " + integer);
    }

    @Test
    public void getShopPrinterTemplateDocumentByPrimaryId() {
        ScOperationPrinterTemplateDocument templateDocument = scOperationPrinterTemplateDocumentService.getShopPrinterTemplateDocumentByPrimaryId(1);
        Assert.assertEquals(templateDocument.getName(), "系统模板-结账单");
    }

    @Test
    public void updateShopPrinterTemplateDocumentByPrimaryId() {
    }

    @Test
    public void listPrinterTemplateDocumentByShopIdAndDocumentType() {
        List<ScOperationPrinterTemplateDocument> scShopPrinterTemplateDocuments = scOperationPrinterTemplateDocumentService.listPrinterTemplateDocumentByShopIdAndDocumentType(0, 1);
        System.out.println("scShopPrinterTemplateDocuments: " + JSON.toJSON(scShopPrinterTemplateDocuments));
    }

}