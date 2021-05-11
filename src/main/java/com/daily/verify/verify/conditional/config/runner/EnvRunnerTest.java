package com.daily.verify.verify.conditional.config.runner;

import com.daily.verify.verify.conditional.config.properties;
import com.daily.verify.verify.conditional.config.service.BaseOperate;
import com.daily.verify.verify.conditional.config.service.SpecialOperate;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class EnvRunnerTest implements ApplicationRunner {
    @Autowired
    properties properties;
    @Autowired
    BaseOperate baseOperate;
    @Autowired
    SpecialOperate specialOperate;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //启动后执行
        baseOperate.init(specialOperate);
        System.out.println("启动后redisTemplate调用redis");
        redisTemplate.opsForValue().set("aaa", "111");
        System.out.println("redis中的数据为:" + redisTemplate.opsForValue().get("aaa"));
    }
}
