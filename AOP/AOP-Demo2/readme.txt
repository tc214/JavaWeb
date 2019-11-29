# 开发环境
IDEA2019.2.3 Tomcat8.5 JDK1.8 MAVEN


# 导入代码，配置Maven, tomcat

# 编译

# 执行TestAop类主方法：
控制台打印如下日志（时间会有所差别）：
```
注解式拦截-before,action.name=注解式拦截的add操作
DemoAnnotationServiceImpl.add():基于注解的拦截:add 方法执行了！
注解式拦截after,action.name=注解式拦截的add操作
方法规则式拦截before,method.name=add
DemoMethodServiceImpl.add(): add方法执行了！
方法规则式拦截after,method.name=add
```

打印说明：
   注解式拦截：在方法执行前后，打印执行方法上的注解属性；
   方法式拦截：在方法执行前后，打印方法名称。









##
```
AOP使用场景：
Authentication 权限
Caching 缓存
Context passing 内容传递
Error handling 错误处理
Lazy loading　懒加载
Debugging　　调试
logging, tracing, profiling and monitoring　记录跟踪　优化　校准
Performance optimization　性能优化
Persistence　　持久化
Resource pooling　资源池
Synchronization　同步
Transactions 事务
```

