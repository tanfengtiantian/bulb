package com.maxzuo.websocket;

import java.security.Principal;

/**
 * websocket 连接的认证用户
 * Created by zfh on 2018/12/09
 */
public final class ClientUser implements Principal {

    private final String name;

    public ClientUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
