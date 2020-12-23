package com.daily.verify.verify.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Component
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public Object defaultExceptionHandler(Exception e) {
        if (e instanceof ServiceException) {
            log.error("服务异常");
            return new Response(((ServiceException) e).getCode(), e.getMessage());
        }
        if (e instanceof RegularException) {
            log.error("规则异常");
            return new Response(((RegularException) e).getCode(), "1", e.getMessage(), ((RegularException) e).getData());
        }
        return new Response(e.getMessage());
    }

}
