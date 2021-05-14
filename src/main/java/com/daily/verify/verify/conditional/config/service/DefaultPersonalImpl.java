package com.daily.verify.verify.conditional.config.service;

import com.daily.verify.verify.conditional.config.service.impl.LocalSpecialImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public abstract class DefaultPersonalImpl implements PersonalizedOperate {
    Logger logger = LoggerFactory.getLogger(LocalSpecialImpl.class);

    @Autowired
    private Environment environment;

    /**
     * 返回当前是使用redis还是local
     * @return 1, 0
     */
    public int getLoadDataStatus() {
        String property = environment.getProperty("spring.redis.usewhichflag");
        if (StringUtils.isEmpty(property))
            logger.error("缺少系统环境变量配置,spring.redis.usewhichflag");
        return Integer.valueOf(property);
    }
}
