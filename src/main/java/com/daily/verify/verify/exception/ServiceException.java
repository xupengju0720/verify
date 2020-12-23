package com.daily.verify.verify.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {
    private String code;

    /**
     * 构造一个业务异常类
     *
     * @param code    错误码,注意约定的业务错误码都是大于600的
     * @param message 错误信息
     */
    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }


}
