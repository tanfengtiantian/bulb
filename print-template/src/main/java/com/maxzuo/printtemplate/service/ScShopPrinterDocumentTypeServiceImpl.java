package com.maxzuo.printtemplate.service;

import com.maxzuo.printtemplate.api.IScShopPrinterDocumentTypeService;
import com.maxzuo.printtemplate.dao.ScShopPrinterDocumentTypeMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterDocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 打印模板实现类
 * Created by zfh on 2018/12/12
 */
@Service("scShopPrinterDocumentTypeService")
public class ScShopPrinterDocumentTypeServiceImpl implements IScShopPrinterDocumentTypeService {

    @Autowired
    private ScShopPrinterDocumentTypeMapper scShopPrinterDocumentTypeMapper;

    @Override
    public ScShopPrinterDocumentType getPrinterDocumentTypeByPrimaryId(Integer id) {
        return scShopPrinterDocumentTypeMapper.selectPrinterDocumentTypeByPrimaryId(id);
    }

    @Override
    public List<ScShopPrinterDocumentType> listPrinterDocumentType() {
        return scShopPrinterDocumentTypeMapper.selectPrinterDocumentType();
    }

    @Override
    public Integer updatePrinterDocumentType(ScShopPrinterDocumentType scShopPrinterDocumentType) {
        return scShopPrinterDocumentTypeMapper.updatePrinterDocumentType(scShopPrinterDocumentType);
    }
}
