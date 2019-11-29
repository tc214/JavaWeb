package org.tc.aop;


import java.lang.annotation.*;


/**
 * 方法注解
 * 编写拦截规则的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String name();
}
