package com.maxzuo.printtemplate.api;

import com.maxzuo.printtemplate.model.ScShopPrinterDocumentType;

import java.util.List;

/**
 * 打印模板-文档类型Service
 * Created by zfh on 2018/12/12
 */
public interface IScShopPrinterDocumentTypeService {

    /**
     * 主键查询文档类型
     * @param id 主键
     * @return 实体
     */
    ScShopPrinterDocumentType getPrinterDocumentTypeByPrimaryId (Integer id);

    /**
     * 查询文档类型列表（status=1）
     * @return list
     */
    List<ScShopPrinterDocumentType> listPrinterDocumentType ();

    /**
     * 更新文档类型属性
     * @param scShopPrinterDocumentType 实体
     * @return 受影响的行数
     */
    Integer updatePrinterDocumentType (ScShopPrinterDocumentType scShopPrinterDocumentType);
}
