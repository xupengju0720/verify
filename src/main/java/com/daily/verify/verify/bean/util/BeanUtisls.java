package com.daily.verify.verify.bean.util;

import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BeanUtisls {
    public static void main(String[] args) {
        Person p = new Person();
        p.setDate(new Date());
        p.setName("小明");
        p.setSex("1");
        p.setStatus(1);
        Student s = new Student();
        s.setName("小红");
        BeanUtils.copyProperties(p, s);


        Person pp = new Person();
        pp.setDate(new Date());
        pp.setName("小王");

        pp.setStatus(1);
        Student ss = new Student();
        ss.setSex("1");
        BeanUtils.copyProperties(pp, ss, Person.class);
        int a = 0;

    }

}
