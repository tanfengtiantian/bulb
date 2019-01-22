package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterCustomComponentService;
import com.maxzuo.printtemplate.dao.ScShopPrinterCustomComponentMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterCustomComponent;
import com.maxzuo.printtemplate.model.ScShopPrinterSystemComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 打印模板-自定义组件相关Service
 * Created by zfh on 2019/01/03
 */
@Service("scShopPrinterCustomComponentService")
public class ScShopPrinterCustomComponentImpl implements IScShopPrinterCustomComponentService {

    @Autowired
    private ScShopPrinterCustomComponentMapper scShopPrinterCustomComponentMapper;

    @Override
    public Integer saveMultiplePrinterCustomComponent(List<ScShopPrinterCustomComponent> shopPrinterCustomComponentList) {
        return scShopPrinterCustomComponentMapper.insertMultiplePrinterCustomComponent(shopPrinterCustomComponentList);
    }

    @Override
    public Integer removeMultiplePrinterCustomComponentByTemplateId(Integer templateId) {
        return scShopPrinterCustomComponentMapper.updateMultiplePrinterCustomComponentByTemplateId(templateId);
    }

    @Override
    public List<ScShopPrinterCustomComponent> listPrinterTemplateCustomComponentByTemplateId(Integer documentTemplateId) {
        return scShopPrinterCustomComponentMapper.selectPrinterTemplateCustomComponentByTemplateId(documentTemplateId);
    }
}
