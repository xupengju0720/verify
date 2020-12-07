package com.daily.verify.verify.excel.easyexcel.service.impl;


import com.daily.verify.verify.excel.easyexcel.common.ApiResponse;
import com.daily.verify.verify.excel.easyexcel.model.expire.UserExpire;
import com.daily.verify.verify.excel.easyexcel.model.param.UserParm;
import com.daily.verify.verify.excel.easyexcel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserExpire, UserParm> implements UserService {

    @Override
    public List<UserExpire> readyData(List<UserParm> userParms) {
        //王五	20	137831654264	男	0
        //李四	21	137831654266	男	1
        //张三	22	137831654265	男	2
        List<UserExpire> result = new ArrayList<>();
        UserExpire expire = new UserExpire();
        expire.setName("王五");
        expire.setAge(21);
        expire.setMobile("137831654266");
        expire.setSex("男");
        expire.setIndex(2);

        UserExpire expire2 = new UserExpire();
        expire2.setName("王五");
        expire2.setAge(21);
        expire2.setMobile("137831654265");
        expire2.setSex("男");
        expire2.setIndex(2);

        result.add(expire);
        result.add(expire2);

        return result;
    }


    @Override
    public ApiResponse ExcelHandel(String funcId, String groupId) {
        return super.ExcelHandel(funcId, groupId, new UserExpire(), new UserParm());
    }
}
