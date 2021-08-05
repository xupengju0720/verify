package com.daily.verify.verify.callback;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringTools {
    public static void StringSplitToChar(String string, XCallBackService xCallBackService) {
        if (StringUtils.isEmpty(string)) {
            System.out.println("字符串为空，中断");
        }
        xCallBackService.call(string.trim());
        return;
    }

    //注意分割只是一种随便的实现方式
    //这里的目的是把 回调函数 加进来 写法

    public static void main(String[] args) {
        String string = "   xupengju   ";
        List<String> split = new ArrayList<>();
        StringSplitToChar(string, (param) -> {
            for (int i = 0; i < param.length(); i++) {
                split.add(param.substring(i, i + 1));
            }
        });
        for (String s : split) {
            System.out.print(s);
            System.out.print(",");
        }
    }
}
