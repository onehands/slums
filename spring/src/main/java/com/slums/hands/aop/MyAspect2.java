package com.slums.hands.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/14 14:33
 * @version: 1.0
 */
@Aspect
@Slf4j
@Component
public class MyAspect2 {
    @Pointcut("execution(* com.slums.hands.service..*(..))")
    public void controllerAspect2() {
    }

    @Before("controllerAspect2()")
    public void serviceAround(JoinPoint pjp) {
        long current = System.currentTimeMillis();
        final String className = pjp.getTarget().getClass().getSimpleName();
        final String methodName = pjp.getSignature().getName();
        log.info("before {}.{} with param {} ",
                className,
                methodName,
                pjp.getArgs());
    }

    @AfterReturning("controllerAspect2()")
    public void afterReturning() {
        log.info("afterReturning");
    }

    @Around("@annotation(com.slums.hands.annotation.AutoLog)")
    public Object serviceAround(ProceedingJoinPoint pjp) throws Throwable {
        long current = System.currentTimeMillis();
        final String className = pjp.getTarget().getClass().getSimpleName();
        final String methodName = pjp.getSignature().getName();
        Object obj = pjp.proceed();
        log.info("around {}.{} return {} , take {} ",
                className,
                methodName,
                obj,
                System.currentTimeMillis() - current);
        return obj;
    }
}
