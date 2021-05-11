package com.daily.verify.verify.conditional.config.service.impl;

import com.daily.verify.verify.conditional.config.condition.RedisCondition;
import com.daily.verify.verify.conditional.config.service.DefaultPersonalImpl;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(value = RedisCondition.class)
public class RedisPersonalizedImpl extends DefaultPersonalImpl {
    @Override
    public void putData() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void delData() {

    }
}
