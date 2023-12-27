package com.eclan.springplayground.common.toggle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ToggleAspect {

    @Before(value = "@annotation(TogglePoint)")
    public void someMethod(JoinPoint joinPoint) {
        var signature = (MethodSignature) joinPoint.getSignature();

        log.info("In Aspect.");

        // Method annotation
        var method = signature.getMethod();
        var accountOperation = method.getAnnotation(TogglePoint.class);
        log.info("Account operation annotation: " + accountOperation);
        log.info("Account operation value: " + accountOperation.someMethod());
    }

}
