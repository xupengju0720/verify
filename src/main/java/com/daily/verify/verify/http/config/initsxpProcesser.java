package com.daily.verify.verify.http.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Configuration
public class initsxpProcesser implements EnvironmentPostProcessor, Ordered {
    private static final Integer POST_PROCESSOR_ORDER = Integer.MIN_VALUE + 10;

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("init-out-properties:begin");
        Map<String, Object> map = buildEnv();
        Properties properties = new Properties();
        setParams(properties, map);
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new PropertiesPropertySource("application,properties", properties));
        System.out.println("init-out-properties:end");
    }

    private void setParams(Properties properties, Map<String, Object> map) {
        if (!CollectionUtils.isEmpty(map)) {
            for (String s : map.keySet()) {
                properties.put(s, map.get(s));
            }
        } else {
            System.out.println("环境配置信息为空，请检查");
        }
    }

    private Map<String, Object> buildEnv() {
        //获取到数据
        Map<String, Object> result = new HashMap<>();
        result.put("http.ip", "127.0.0.1");
        result.put("http.port", "8080");
        result.put("http.type", "1");
        result.put("http.name", "xxx.com");
        result.put("http.timeOut", "10");
        return result;
    }


    @Override
    public int getOrder() {
        return this.POST_PROCESSOR_ORDER + 1;
    }
}
