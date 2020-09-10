package com.daily.verify.verify.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class commonMatcher {
    public static void main(String[] args) {
        String destStr = "规则校验【发放时间段】不通过】";
        String regex = "【.*】";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(destStr);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}
