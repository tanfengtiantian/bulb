package com.maxzuo.printtemplate.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maxzuo.printtemplate.api.IScShopPrinterDeviceService;
import com.maxzuo.printtemplate.dao.ScShopPrinterDeviceMapper;
import com.maxzuo.printtemplate.model.ScShopPrinterDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 打印机相关Serice实现类
 * Created by zfh on 2019/01/09
 */
@Service("scShopPrinterDeviceService")
public class ScShopPrinterDeviceServiceImpl implements IScShopPrinterDeviceService {

    @Autowired
    private ScShopPrinterDeviceMapper scShopPrinterDeviceMapper;

    @Override
    public Integer save(ScShopPrinterDevice record) {
        scShopPrinterDeviceMapper.insert(record);
        return record.getId();
    }

    @Override
    public ScShopPrinterDevice getScShopPrinterDeviceByPrimaryKey(Integer id) {
        return scShopPrinterDeviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<ScShopPrinterDevice> listPrinterDeviceByShopId(Integer shopId, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<ScShopPrinterDevice> printerDeviceList = scShopPrinterDeviceMapper.selectPrinterDeviceListByShopId(shopId);
        return new PageInfo<>(printerDeviceList);
    }

    @Override
    public Integer updateByPrimaryKeySelective(ScShopPrinterDevice record) {
        return scShopPrinterDeviceMapper.updateByPrimaryKeySelective(record);
    }
}
