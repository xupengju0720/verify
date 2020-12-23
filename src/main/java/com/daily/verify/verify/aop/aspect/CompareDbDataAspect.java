package com.daily.verify.verify.aop.aspect;

import com.daily.verify.verify.aop.anotation.CompareDbDataAfterImport;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class CompareDbDataAspect {
    private String compareDbDataAfterImport = "com.daily.verify.verify.aop.anotation.CompareDbDataAfterImport";

    /***
     *定义aop切入点
     */
    @Pointcut("@annotation(com.daily.verify.verify.aop.anotation.CompareDbDataAfterImport)")
    public void compareAspect() {

    }

    @Before(value = "compareAspect()")
    public void compareBefore(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CompareDbDataAfterImport cp = method.getAnnotation(CompareDbDataAfterImport.class);
        log.info("切面切入之前" + cp.type() + "|" + cp.description());
    }

    @After("compareAspect()")
    public void after(JoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CompareDbDataAfterImport cp = method.getAnnotation(CompareDbDataAfterImport.class);
        log.info(cp.type() + "上场项完成，执行对比操作");
    }
}
