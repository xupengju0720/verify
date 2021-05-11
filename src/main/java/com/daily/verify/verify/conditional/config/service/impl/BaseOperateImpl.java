package com.daily.verify.verify.conditional.config.service.impl;

import com.daily.verify.verify.conditional.config.properties;
import com.daily.verify.verify.conditional.config.service.BaseOperate;
import com.daily.verify.verify.conditional.config.service.SpecialOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseOperateImpl implements BaseOperate {
    @Autowired
    properties properties;

    @Override
    public void init(SpecialOperate specialOperate) {
        try {
            specialOperate.getConnect(properties);
            before(specialOperate);
            after(specialOperate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void before(SpecialOperate specialOperate) {
        try {
            specialOperate.clearData(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void after(SpecialOperate SpecialOperate) {
        SpecialOperate.close();
    }
}
