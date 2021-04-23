package com.sinosoft.elasticjob.config.logaspect;

import com.sinosoft.elasticjob.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DubboLogAspect {
    @Pointcut("execution(public * com.sinosoft.elasticjob.*.service.dubbo..*.*(..))")
    public void DubboPointcut() {
    }

    @Before("DubboPointcut()")
    public void beforeMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String typeName = signature.getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();
        if(log.isInfoEnabled()){
            log.info(typeName + "#" + methodName + " begin, params = {}", new Object[]{args});
        }
    }

    @AfterReturning(value="DubboPointcut()",returning="result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String typeName = signature.getDeclaringTypeName();
        String resultJson = GsonUtils.toJson(result);
        resultJson = getLogString(resultJson);
        if(log.isInfoEnabled()){
            log.info(typeName + "#" + methodName + " end, result = {}", new Object[]{resultJson});
        }
    }

    @AfterThrowing(value="DubboPointcut()",throwing="e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String typeName = signature.getDeclaringTypeName();
        if(log.isErrorEnabled()){
            log.error(typeName + "#" + methodName + " [error], errorMsg = " + e.getMessage(), e);
        }
    }

    private String getLogString(String logInfo){
        if(logInfo.length()>5000){
            logInfo = logInfo.substring(0, 5000) + "...";
        }
        return logInfo;
    }

}
