package org.tc.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 切面
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(org.tc.aop.Action)")
    public void annotationPointCut() {
        System.out.println("-------annotationPointCut-------");
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截after,action.name=" + action.name());
    }

    @Before("annotationPointCut()")
    public void beforeAnn(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截-before,action.name=" + action.name());
    }

    @Before("execution(* org.tc.aop.DemoMethodServiceImpl.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截before,method.name=" + method.getName());
    }

    @After("execution(* org.tc.aop.DemoMethodServiceImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截after,method.name=" + method.getName());
//        Action action = method.getAnnotation(Action.class); // null
//        System.out.println("方法规则式拦截after,action.name=" + action.name());
    }
}
