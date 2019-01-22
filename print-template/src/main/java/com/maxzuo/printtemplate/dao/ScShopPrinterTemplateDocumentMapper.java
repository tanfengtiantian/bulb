package com.maxzuo.printtemplate.dao;

import com.maxzuo.printtemplate.model.ScShopPrinterTemplateDocument;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 打印模板-模板相关Mapper
 * Created by zfh on 2018/12/12
 */
@Mapper
public interface ScShopPrinterTemplateDocumentMapper {

    /**
     * 添加模板
     * @param scShopPrinterTemplateDocument {@link ScShopPrinterTemplateDocument}
     * @return 受影响的行数
     */
    Integer insertShopPrinterTemplateDocument (ScShopPrinterTemplateDocument scShopPrinterTemplateDocument);

    /**
     * 根据主键查询模板
     * @param id 主键
     * @return {@link ScShopPrinterTemplateDocument}
     */
    ScShopPrinterTemplateDocument selectShopPrinterTemplateDocumentByPrimaryId(Integer id);

    /**
     * 根据模板名称查询模板
     * @param name 模板名称
     * @return {@link ScShopPrinterTemplateDocument}
     */
    ScShopPrinterTemplateDocument selectShopPrinterTemplateDocumentByName(String name);

    /**
     * 根据主键更新模板
     * @param scShopPrinterTemplateDocument {@link ScShopPrinterTemplateDocument}
     * @return 受影响的行数
     */
    Integer updateShopPrinterTemplateDocumentByPrimaryId(ScShopPrinterTemplateDocument scShopPrinterTemplateDocument);

    /**
     * 移除自定义模板（软删除）
     * @param id 主键
     * @return 受影响的条数
     */
    Integer updateShopPrinterTemplateDocumentStatusByPrimaryId(Integer id);

    /**
     * 根据店铺id和票据类型 更新模板状态
     * @param shopId 店铺id
     * @param documentType 票据类型
     * @return 受影响条数
     */
    Integer updateShopPrinterTemplateDocumentStatusByShopIdAndDocumentType(@Param("shopId") Integer shopId, @Param("documentType") Integer documentType);

    /**
     * 查询店铺下模板列表和默认的模板
     * @param shopId 店铺id
     * @param documentType 票据类型
     * @return list
     */
    List<ScShopPrinterTemplateDocument> selectPrinterTemplateDocumentByShopIdAndDocumentType (@Param("shopId") Integer shopId, @Param("documentType") Integer documentType);
}
