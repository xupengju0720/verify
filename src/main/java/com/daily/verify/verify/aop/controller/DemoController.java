package com.daily.verify.verify.aop.controller;

import com.daily.verify.verify.aop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    DemoService service;

    @GetMapping("/select")
    private List<String> select() {
        return service.selectData();
    }
}
