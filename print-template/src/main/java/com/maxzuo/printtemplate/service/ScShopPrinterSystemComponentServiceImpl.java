package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterSystemComponentService;
import com.maxzuo.printtemplate.dao.ScShopPrinterSystemComponentMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterSystemComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 打印模板-系统组件实现类
 * Created by zfh on 2018/12/27
 */
@Service("scShopPrinterSystemComponentService")
public class ScShopPrinterSystemComponentServiceImpl implements IScShopPrinterSystemComponentService {

    @Autowired
    private ScShopPrinterSystemComponentMapper scShopPrinterSystemComponentMapper;

    @Override
    public Integer savePrinterSystemComponent(ScShopPrinterSystemComponent systemComponent) {
        return scShopPrinterSystemComponentMapper.insertPrinterSystemComponent(systemComponent);
    }

    @Override
    public List<ScShopPrinterSystemComponent> listPrinterSystemComponentByTemplateType(Integer templateType) {
        return scShopPrinterSystemComponentMapper.selectPrinterSystemComponentListByTemplateTypeId(templateType);
    }
}
