package com.taiyangguo.aspectLog.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(public * com.taiyangguo.aspectLog.controller..*.*(..))")
    public void ControllerPointcut() {
    }

    @Before("ControllerPointcut()")
    public void beforeMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String typeName = signature.getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();
        log.info(typeName + "#" + methodName + " begin, params = {}", new Object[]{args});
    }

    @AfterReturning(value="ControllerPointcut()",returning="result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String typeName = signature.getDeclaringTypeName();
        log.info(typeName + "#" + methodName + " end, result = {}", new Object[]{JSONObject.toJSONString(result)});
    }

    @AfterThrowing(value="ControllerPointcut()",throwing="e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String typeName = signature.getDeclaringTypeName();
        log.error(typeName + "#" + methodName + " [error], errorMsg = " + e.getMessage(), e);
    }

}
