package com.daily.verify.verify.excel.easyexcel.controller;

import com.daily.verify.verify.excel.easyexcel.common.ApiResponse;
import com.daily.verify.verify.excel.easyexcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/readExcel")
    @ResponseBody
    public ApiResponse readExcel(String funcId, String groupId) {
        return service.ExcelHandel(funcId, groupId);
    }
}
