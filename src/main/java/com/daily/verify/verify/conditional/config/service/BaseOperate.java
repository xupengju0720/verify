package com.daily.verify.verify.conditional.config.service;

/**
 * 基础操作，比如初始化、之前、之后的执行方法
 */
public interface BaseOperate {
    void init(SpecialOperate specialOperate);

    void before(SpecialOperate specialOperate);

    void after(SpecialOperate SpecialOperate);
}
