package com.taiyangguo.aspectLog.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TestLogAspect {
    //com.kzj.kzj_rabbitmq.controller 包中所有的类的所有方法切面
    //@Pointcut("execution(public * com.kzj.kzj_rabbitmq.controller.*.*(..))")

    //只针对 MessageController 类切面
    //@Pointcut("execution(public * com.kzj.kzj_rabbitmq.controller.MessageController.*(..))")

    //统一切点,对com.kzj.kzj_rabbitmq.controller及其子包中所有的类的所有方法切面
    @Pointcut("execution(public * com.taiyangguo.aspectLog.controller..*.*(..))")
    public void ControllerPointcut() {
    }

    //前置通知
    @Before("ControllerPointcut()")
    public void beforeMethod(JoinPoint joinPoint){
//        log.info("-----------------调用了前置通知--------------------");
    }

    //@After: 后置通知
    @After("ControllerPointcut()")
    public void afterMethod(JoinPoint joinPoint){
//        log.info("-------------------调用了后置通知----------------");
    }

    //@AfterRunning: 返回通知 rsult为返回内容
    @AfterReturning(value="ControllerPointcut()",returning="result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
//        log.info("--------------------调用了返回通知----------------");
    }

    //@AfterThrowing: 异常通知
    @AfterThrowing(value="ControllerPointcut()",throwing="e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e){
//        log.info("---------------------调用了异常通知-------------------");
    }

    //@Around：环绕通知
    @Around("ControllerPointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
//        log.info("--------------环绕通知调用切入点方法前--------------------");
        Object object = pjp.proceed();
//        log.info("----------------环绕通知调用切入点方法后--返回值：" +object);
        return object;
    }


}
