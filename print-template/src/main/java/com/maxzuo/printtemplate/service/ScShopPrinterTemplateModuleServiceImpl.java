package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterTemplateModuleService;
import com.maxzuo.printtemplate.dao.ScShopPrinterTemplateModuleMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterTemplateModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 打印模板-模块接口实现类
 * Created by zfh on 2018/12/12
 */
@Service("scShopPrinterTemplateModuleService")
public class ScShopPrinterTemplateModuleServiceImpl implements IScShopPrinterTemplateModuleService {

    @Autowired
    private ScShopPrinterTemplateModuleMapper scShopPrinterTemplateModuleMapper;

    @Override
    public List<ScShopPrinterTemplateModule> listPrinterTemplateModuleByDocumentId(Integer documentType) {
        return scShopPrinterTemplateModuleMapper.selectPrinterTemplateModuleByDocumentId(documentType);
    }
}
