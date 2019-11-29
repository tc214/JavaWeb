package org.tc.aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * 配置類：用于开启spring对切面的自动代理
 */
@Configuration
@ComponentScan("org.tc.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
