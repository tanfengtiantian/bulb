package com.maxzuo.printtemplate.dao;

import com.maxzuo.printtemplate.model.ScShopPrinterTemplateModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 打印模板-模块Mapper
 * Created by zfh on 2018/12/12
 */
@Mapper
public interface ScShopPrinterTemplateModuleMapper {

    /**
     * 通过文档类型查询包含的模块
     * @param documentType 文档类型主键
     * @return list
     */
    List<ScShopPrinterTemplateModule> selectPrinterTemplateModuleByDocumentId (Integer documentType);
}
