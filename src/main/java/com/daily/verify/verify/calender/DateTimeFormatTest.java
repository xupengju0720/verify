package com.daily.verify.verify.calender;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeFormatTest {

    public static void main(String[] args) {
        //日期正则校验
        Pattern pattern = Pattern.compile("^(\\d{4})/(0\\d{1}|1[0-2])/(0\\d{1}|[12]\\d{1}|3[01])(T| )?((0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1}))?$");
        String test1 = "1996/11/15 23:25:55";
        Matcher matcher = pattern.matcher(test1);
        System.out.println(matcher.matches());//返回true

        //保留两位小数测试
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double dd =1111000.7000000001;
        System.out.println(decimalFormat.format(dd));
    }
}
