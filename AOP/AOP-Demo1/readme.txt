# 开发环境
IDEA2019.2.3 Tomcat8.5 JDK1.8 MAVEN


# 导入代码，配置Maven, tomcat

# 编译

# 执行TestAop类主方法：
控制台打印如下日志（时间会有所差别）：
```
代理----前----CurrentTime = 354724997529181
------11111------按下HelloWorld1.printHelloWorld()-----11111111-------
代理----后----CurrentTime = 354724998237258

------11111------按下HelloWorld1.doPrint()-----11111111-------

代理----前----CurrentTime = 354724998504358
------11111------按下HelloWorld2.printHelloWorld()-----11111111-------
代理----后----CurrentTime = 354724998581215

------11111------按下HelloWorld2.doPrint()-----11111111-------
```

打印说明：
  监控了printHelloWorld方法执行前后。用途：监控方法执行时长。







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

