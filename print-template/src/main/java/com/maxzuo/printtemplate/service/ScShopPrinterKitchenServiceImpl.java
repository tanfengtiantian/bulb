package com.maxzuo.printtemplate.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxzuo.printtemplate.api.IScShopPrinterKitchenService;
import com.maxzuo.printtemplate.dao.ScShopPrinterKitchenMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterKitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出票口相关Service实现类
 * Created by zfh on 2019/01/09
 */
@Service("scShopPrinterKitchenService")
public class ScShopPrinterKitchenServiceImpl implements IScShopPrinterKitchenService {

    @Autowired
    private ScShopPrinterKitchenMapper scShopPrinterKitchenMapper;

    @Override
    public Integer save(ScShopPrinterKitchen record) {
        scShopPrinterKitchenMapper.insert(record);
        return record.getId();
    }

    @Override
    public ScShopPrinterKitchen getByPrimaryKey(Integer id) {
        return scShopPrinterKitchenMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<ScShopPrinterKitchen> listPrinterKitchenByShopId(Integer shopId, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<ScShopPrinterKitchen> kitchenList = scShopPrinterKitchenMapper.selectPrinterKitchenListByShopId(shopId);
        return new PageInfo<>(kitchenList);
    }

    @Override
    public Integer updateByPrimaryKeySelective(ScShopPrinterKitchen record) {
        return scShopPrinterKitchenMapper.updateByPrimaryKeySelective(record);
    }
}
