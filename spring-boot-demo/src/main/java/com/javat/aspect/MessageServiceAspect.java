package com.javat.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author tai
 * @create 2021-07-29 13:31
 */
@Aspect
@Component
@Slf4j
public class MessageServiceAspect {
    @Around("execution(* com.javat.service..*.*(..))")
    public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable {
        log.info("begin exec method...参数为:{}", Arrays.toString(point.getArgs()));
        Object obj = point.proceed();
        log.info("end exec method...返回结果为:{}", obj);
        return obj;
    }
}
