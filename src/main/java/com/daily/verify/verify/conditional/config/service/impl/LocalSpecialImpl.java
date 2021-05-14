package com.daily.verify.verify.conditional.config.service.impl;

import com.daily.verify.verify.conditional.config.condition.LocalCondition;
import com.daily.verify.verify.conditional.config.properties;
import com.daily.verify.verify.conditional.config.service.SpecialOperate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;


@Service
@Conditional(value = LocalCondition.class)
public class LocalSpecialImpl implements SpecialOperate {
    Logger logger = LoggerFactory.getLogger(LocalSpecialImpl.class);
    @Autowired
    LocalPersonalImpl localPersonal;

    @Override
    public void getConnect(properties properties) {
        logger.info("本地初始化连接");
        CheckConnect(properties);
    }

    @Override
    public boolean CheckConnect(properties properties) {
        logger.info("本地校验连接");
        return true;
    }

    @Override
    public void clearData(properties properties) {
        logger.info("本地清除数据");
        localPersonal.clear();
    }

    @Override
    public void close() {
        logger.info("本地关闭资源");
    }
}
