package com.daily.verify.verify.exception;

import lombok.Data;

@Data
public class RegularException extends RuntimeException {
    private String code;
    private String data;

    /**
     * 构造一个业务异常类
     *
     * @param code    错误码,注意约定的业务错误码都是大于600的
     * @param message 错误信息
     */
    public RegularException(String code, String message, String data) {
        super(message);
        this.code = code;
        this.data = data;
    }

}
