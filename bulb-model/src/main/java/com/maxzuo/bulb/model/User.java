package com.maxzuo.bulb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体
 * Created by zfh on 2018/10/08
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3612819328305649707L;

    /** 主键 */
    private Integer           id;

    /** 用户名 */
    private String            username;

    /** 密码 */
    private String            password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\''
               + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
    }
}
