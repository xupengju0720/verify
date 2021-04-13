package com.daily.verify.verify.calender;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeFormatTest {

    public static void main(String[] args) {
        double a = new Double("1");
        double b = new Double("1.00");
        System.out.println(a == b);
    }

    static void vegex() {
        //日期正则校验
        Pattern pattern = Pattern.compile("^(\\d{4})/(0\\d{1}|1[0-2])/(0\\d{1}|[12]\\d{1}|3[01])(T| )?((0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1}))?$");
        String test1 = "1996/11/15 23:25:55";
        Matcher matcher = pattern.matcher(test1);
        System.out.println(matcher.matches());//返回true

        //保留两位小数测试
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double dd = 1111000.7000000001;
        System.out.println(decimalFormat.format(dd));
    }


    public static Date addDays(Date date, int days) {
        return new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
    }

    public static String addDays(String dateStr, int days) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date resultDate = null;
        try {
            Date date = format.parse(dateStr);
            resultDate = new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat resultFormat = new SimpleDateFormat("yyyyMMdd");
        return resultFormat.format(resultDate);
    }

}
