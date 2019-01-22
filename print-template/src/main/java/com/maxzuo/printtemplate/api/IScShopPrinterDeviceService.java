package com.maxzuo.printtemplate.api;

import com.github.pagehelper.PageInfo;
import com.maxzuo.printtemplate.model.ScShopPrinterDevice;

/**
 * 打印机相关Service
 * Created by zfh on 2019/01/09
 */
public interface IScShopPrinterDeviceService {

    /**
     * 新增记录
     * @param record {@link ScShopPrinterDevice}
     * @return 自增主键
     */
    Integer save(ScShopPrinterDevice record);

    /**
     * 根据主键查询记录
     * @param id 主键
     * @return {@link ScShopPrinterDevice}
     */
    ScShopPrinterDevice getScShopPrinterDeviceByPrimaryKey(Integer id);

    /**
     * 查询店铺下所有的打印机（未删除）
     * @param shopId 店铺id
     * @param page   页码
     * @param rows   页条数
     * @return {@link PageInfo}
     */
    PageInfo<ScShopPrinterDevice> listPrinterDeviceByShopId(Integer shopId, Integer page, Integer rows);

    /**
     * 更新记录
     * @param record {@link ScShopPrinterDevice}
     * @return 受影响的条数
     */
    Integer updateByPrimaryKeySelective(ScShopPrinterDevice record);
}
