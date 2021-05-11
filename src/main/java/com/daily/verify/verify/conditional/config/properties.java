package com.daily.verify.verify.conditional.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "spring.redis")
public class properties {
    //true local redis
    private boolean usewhichflag;

    private String redis;
    private String host;
    private int port;
    private String password;

    private String local;

}
