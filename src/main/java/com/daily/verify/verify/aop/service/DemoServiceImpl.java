package com.daily.verify.verify.aop.service;

import com.daily.verify.verify.aop.anotation.CompareDbDataAfterImport;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    @CompareDbDataAfterImport(type = "demo", description = "测试项")
    public List<String> selectData() {
        return Arrays.asList(new String[]{"1", "2", "3", "4"});
    }
}
