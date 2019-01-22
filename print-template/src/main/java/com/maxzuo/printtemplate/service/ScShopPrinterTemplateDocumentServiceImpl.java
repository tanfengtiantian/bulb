package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterTemplateDocumentService;
import com.maxzuo.printtemplate.dao.ScShopPrinterTemplateDocumentMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterTemplateDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 打印模板-文档相关实现类
 * Created by zfh on 2018/12/12
 */
@Service("scShopPrinterTemplateDocumentService")
public class ScShopPrinterTemplateDocumentServiceImpl implements IScShopPrinterTemplateDocumentService {

    @Autowired
    private ScShopPrinterTemplateDocumentMapper scShopPrinterTemplateDocumentMapper;

    @Override
    public Integer saveShopPrinterTemplateDocument(ScShopPrinterTemplateDocument scShopPrinterTemplateDocument) {
        scShopPrinterTemplateDocumentMapper.insertShopPrinterTemplateDocument(scShopPrinterTemplateDocument);
        return scShopPrinterTemplateDocument.getId();
    }

    @Override
    public ScShopPrinterTemplateDocument getShopPrinterTemplateDocumentByPrimaryId(Integer id) {
        return scShopPrinterTemplateDocumentMapper.selectShopPrinterTemplateDocumentByPrimaryId(id);
    }

    @Override
    public ScShopPrinterTemplateDocument getShopPrinterTemplateDocumentByName(String name) {
        return scShopPrinterTemplateDocumentMapper.selectShopPrinterTemplateDocumentByName(name);
    }

    @Override
    public Integer updateShopPrinterTemplateDocumentByPrimaryId(ScShopPrinterTemplateDocument scShopPrinterTemplateDocument) {
        return scShopPrinterTemplateDocumentMapper.updateShopPrinterTemplateDocumentByPrimaryId(scShopPrinterTemplateDocument);
    }

    @Override
    public Integer updateShopPrinterTemplateDocumentStatusByShopIdAndDocumentType(Integer shopId, Integer documentType) {
        return scShopPrinterTemplateDocumentMapper.updateShopPrinterTemplateDocumentStatusByShopIdAndDocumentType(shopId, documentType);
    }

    @Override
    public Integer removeShopPrinterTemplateDocumentByPrimaryId(Integer id) {
        return scShopPrinterTemplateDocumentMapper.updateShopPrinterTemplateDocumentStatusByPrimaryId(id);
    }

    @Override
    public List<ScShopPrinterTemplateDocument> listPrinterTemplateDocumentByShopIdAndDocumentType(Integer shopId, Integer documentType) {
        return scShopPrinterTemplateDocumentMapper.selectPrinterTemplateDocumentByShopIdAndDocumentType(shopId, documentType);
    }
}
