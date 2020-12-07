package com.daily.verify.verify.excel.easyexcel.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义统一接口返回类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String code;
    private String message;
    private Object data;


    public ApiResponse SuccessApiResponse() {
        this.code = ErrorEnum.E_200.getCode();
        this.message = ErrorEnum.E_200.getMessage();
        this.data = null;
        return this;
    }

    public ApiResponse FalseApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        return this;
    }

    public ApiResponse(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.message = errorEnum.getMessage();
        this.data = null;
    }
}