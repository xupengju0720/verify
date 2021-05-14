package com.daily.verify.verify.conditional.config.service.impl;

import com.daily.verify.verify.conditional.config.condition.RedisCondition;
import com.daily.verify.verify.conditional.config.service.DefaultPersonalImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

@Service
@Conditional(value = RedisCondition.class)
public class RedisPersonalizedImpl extends DefaultPersonalImpl {
    Logger logger = LoggerFactory.getLogger(RedisPersonalizedImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

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
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            logger.error(String.format("redis:key[%s]设置失效时间失败，失败原因  %s", key, e.getMessage()));
            return false;
        }
    }

    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error(String.format("redis:key[%s]判断存在失败，失败原因  %s", key, e.getMessage()));
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

}
