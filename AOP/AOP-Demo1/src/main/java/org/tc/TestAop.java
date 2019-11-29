package org.tc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tc.service.HelloWorld;


/**
 * 测试AOP类
 * 使用方法：直接执行该类main方法
 */
public class TestAop {
    public static void main(String[] args){
        //@SuppressWarnings("resource")
        //如果是web项目，则使用以下代码加载配置文件，如果是一般的Java项目，则使用注释的方式
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("conf/springMVC-servlet.xml");
        HelloWorld hw1 = (HelloWorld) appCtx.getBean("proxy");
        HelloWorld hw2 = (HelloWorld) appCtx.getBean("proxy2");
        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();
        System.out.println();

        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
    }
}
