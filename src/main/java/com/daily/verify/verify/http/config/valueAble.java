package com.daily.verify.verify.http.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
//延迟加载
//@Scope("prototype")
public class valueAble implements ApplicationRunner {

    @Value("${http.ip}")
    private String ip;

    @Value("${http.port}")
    private String port;

    @Value("${http.type}")
    private String type;

    @Value("${http.name}")
    private String name;

    public void run() {
        System.out.println("name：" + name);
        System.out.println("ip：" + ip);
        System.out.println("port：" + port);
        System.out.println("type：" + type);
    }

    /**
     * 启动后执行
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("验证环境变量是否存入");
        run();
    }
}
