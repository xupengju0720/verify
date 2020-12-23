package com.daily.verify.verify.exception;

import lombok.Data;

/*
 全局统一返回格式
 */
@Data
public class Response {
    private String code;
    private String status;
    private String msg;
    private Object data;

    public Response(String code, String msg) {
        this.code = code;
        this.status = "";
        this.msg = msg;
        this.data = null;
    }

    public Response(String code, String status, String msg, Object data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Response(String msg) {
        this.msg = msg;
    }

    public Response() {
    }
}
