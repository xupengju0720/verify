package com.daily.verify.verify.conditional.config.service.impl;

import com.daily.verify.verify.conditional.config.condition.LocalCondition;
import com.daily.verify.verify.conditional.config.properties;
import com.daily.verify.verify.conditional.config.service.SpecialOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;


@Service
@Conditional(value = LocalCondition.class)
public class LocalSpecialImpl implements SpecialOperate {
    @Autowired
    LocalPersonalImpl localPersonal;

    @Override
    public void getConnect(properties properties) {
        System.out.println("本地初始化连接");
        CheckConnect(properties);
    }

    @Override
    public boolean CheckConnect(properties properties) {
        System.out.println("本地校验连接");
        return true;
    }

    @Override
    public void clearData(properties properties) {
        System.out.println("本地清除数据");
        localPersonal.clear();
    }

    @Override
    public void close() {
        System.out.println("本地关闭资源");
    }
}
