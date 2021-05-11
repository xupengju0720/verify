package com.daily.verify.verify.conditional.config.service;

import com.daily.verify.verify.conditional.config.properties;

/**
 * 特殊操作，比如建立连接，判断连接状态等
 */
public interface SpecialOperate {
    void getConnect(properties properties) throws Exception;

    boolean CheckConnect(properties properties) throws Exception;

    void clearData(properties properties) throws Exception;

    void close();
}
