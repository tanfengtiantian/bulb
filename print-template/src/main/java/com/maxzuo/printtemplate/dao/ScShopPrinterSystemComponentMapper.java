package com.maxzuo.printtemplate.dao;

import com.maxzuo.printtemplate.model.ScShopPrinterSystemComponent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zfh on 2018/12/27
 */
@Mapper
public interface ScShopPrinterSystemComponentMapper {

    /**
     * 添加系统组件
     * @param systemComponent {@link ScShopPrinterSystemComponent}
     * @return 自增长主键
     */
    Integer insertPrinterSystemComponent (ScShopPrinterSystemComponent systemComponent);

    /**
     * 通过模板类型查询模板组件（系统组件）
     * @param templateType 模板类型
     * @return 组件列表
     */
    List<ScShopPrinterSystemComponent> selectPrinterSystemComponentListByTemplateTypeId(Integer templateType);
}
