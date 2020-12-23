package com.daily.verify.verify.exception.controller;

import com.daily.verify.verify.exception.RegularException;
import com.daily.verify.verify.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常调试
 */
@RestController
@RequestMapping("/error")
public class ErrorTestController {
    @RequestMapping("/test")
    public String test() throws Exception {
        int a = 3;
        switch (a) {
            case 1:
                throw new ServiceException("401", "业务逻辑异常");
            case 2:
                throw new RegularException("402", "规则校验异常", a + "");
            default:
                throw new Exception("其他异常");
        }
    }
}
