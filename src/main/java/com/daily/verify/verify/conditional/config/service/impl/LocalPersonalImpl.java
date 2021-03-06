package com.daily.verify.verify.conditional.config.service.impl;

import com.daily.verify.verify.conditional.config.condition.LocalCondition;
import com.daily.verify.verify.conditional.config.service.DefaultPersonalImpl;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Conditional(value = LocalCondition.class)
public class LocalPersonalImpl extends DefaultPersonalImpl {
    private Map<String, Map<String, Object>> cacheMap = new HashMap<>();

    //清空缓存
    protected void clear() {
        cacheMap.clear();
    }

    @Override
    public void putData() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void delData() {

    }

    @Override
    public boolean expire(String key, long time) {
        return false;
    }

    @Override
    public long getExpire(String key) {
        return 0;
    }

    @Override
    public boolean hasKey(String key) {
        return false;
    }

    @Override
    public void del(String... key) {

    }


}
