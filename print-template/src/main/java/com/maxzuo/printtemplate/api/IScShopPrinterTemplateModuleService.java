package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterTemplateModule;

import java.util.List;

/**
 * 打印模板-模块相关接口
 * Created by zfh on 2018/12/12
 */
public interface IScShopPrinterTemplateModuleService {

    /**
     * 通过文档类型查询包含的模块
     * @param documentType 文档类型主键
     * @return list
     */
    List<ScShopPrinterTemplateModule> listPrinterTemplateModuleByDocumentId (Integer documentType);
}
