package com.maxzuo.bulb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情表实体
 * Created by zfh on 2019/01/18
 */
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 6478560018682239755L;

    /** 主键 */
    private Integer           id;

    /** 用户ID */
    private Integer           userId;

    /** 订单号 */
    private String            orderNo;

    /** 商品ID */
    private Integer           productId;

    /** 价格 */
    private BigDecimal        price;

    /** 创建时间 */
    private Date              createTime;

    /** 更新时间 */
    private Date              updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", userId=" + userId + ", orderNo='" + orderNo + '\'' + ", productId="
               + productId + ", price=" + price + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}
