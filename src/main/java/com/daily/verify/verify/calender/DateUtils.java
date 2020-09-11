package com.daily.verify.verify.calender;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    public static final String DS_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";


    public static String getOldDate(int year, int day, int month) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DS_DATE_FORMAT);
        Calendar c = Calendar.getInstance();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        c.setTime(new Date());
        c.add(Calendar.YEAR, year);
        c.add(Calendar.DAY_OF_YEAR, day);
        c.add(Calendar.MONTH, month);
        return simpleDateFormat.format(c.getTime());
    }

    public static void main(String[] args) {
        System.out.print("当前时间");
        System.out.println(getOldDate(0, 0, 0));
        System.out.print("生成时间");
        System.out.println(getOldDate(-1, -14, -2));
    }
}
