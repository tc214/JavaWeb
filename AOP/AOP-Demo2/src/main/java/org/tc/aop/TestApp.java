package org.tc.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationServiceImpl demoAnnotationService = context.getBean(DemoAnnotationServiceImpl.class);
        DemoMethodServiceImpl demoMethodService = context.getBean(DemoMethodServiceImpl.class);
        demoAnnotationService.add();//基于注解的拦截
        demoMethodService.add();//给予方法规则的拦截
        context.close();

    }
}
