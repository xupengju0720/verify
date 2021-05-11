package com.daily.verify.verify.conditional.config.service.impl;


import com.daily.verify.verify.conditional.config.condition.RedisCondition;
import com.daily.verify.verify.conditional.config.properties;
import com.daily.verify.verify.conditional.config.service.SpecialOperate;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

@Service
@Conditional(value = RedisCondition.class)
public class RedisSpecialImpl implements SpecialOperate {

    Jedis jedis;

    @Override
    public void getConnect(properties properties) {
        System.out.println("redis初始化");
        CheckConnect(properties);
    }

    @Override
    public boolean CheckConnect(properties properties) {
        System.out.println("jedis验证redis是否可正常连接,redis初始化连接");
        boolean result = true;
        try {
            jedis = new Jedis(properties.getHost(), properties.getPort());
            //jedis.auth(properties.getPassword());//密码
            jedis.ping();
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public void clearData(properties properties) {
        System.out.println("redis清空数据");
        //获取所有的Redis的key数据
        Set<String> set = jedis.keys("*");
        Iterator<String> it = set.iterator();
        //全部删除所有的redis数据
        while (it.hasNext()) {
            String str = it.next();
            jedis.del(str);
        }
    }

    @Override
    public void close() {
        System.out.println("jedis关闭redis连接");
        jedis.close();
    }
}
