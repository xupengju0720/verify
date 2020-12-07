package com.daily.verify.verify.excel.easyexcel.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    E_200("200", "正常"),
    E_400("400", "400错误"),
    E_498("498", "文件路径配置不存在"),
    E_499("499", "文件不存在或者文件格式异常"),
    E_500("T500", "内部异常");
    private String code;
    private String message;

    /**
     * 根据Code获取对应报错信息
     */
    public static String getMessageByCode(String Code) {
        for (ErrorEnum c : ErrorEnum.values()) {
            if (c.getCode() == Code) {
                return c.getMessage();
            }
        }
        return null;
    }
}