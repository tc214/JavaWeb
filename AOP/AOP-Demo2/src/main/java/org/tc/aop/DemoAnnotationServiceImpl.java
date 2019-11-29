package org.tc.aop;


import org.springframework.stereotype.Service;

/**
 * 使用Action注解的被拦截类
 */
@Service
public class DemoAnnotationServiceImpl {


    @Action(name = "注解式拦截的add操作")
    public void add() {
        System.out.println("DemoAnnotationServiceImpl.add():基于注解的拦截:add 方法执行了！");
    }
}
