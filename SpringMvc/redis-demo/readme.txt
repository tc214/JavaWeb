# 开发环境
IDEA2019.2.3 Tomcat8.5 JDK1.8 MAVEN


# 导入代码，配置Maven, tomcat

# 编译，启动运行

# 测试-浏览器打开：
http://localhost:8080/test/index
http://localhost:8080/test/getUserInfo?userName=12
http://localhost:8080/test/getValue?key=18


# 版本说明
## v1.0
20191120 增加redis;
redis配置步骤:
```
1.引入redis依赖--pom.xml；
2.创建redis配置类--RedisCacheConfig.java；
3.新建redis配置属性文件--redis.properties；
4.redis连接池的配置--dispatcher-servlet.xml；
5.创建redis工具类--RedisUtils.java；

```


# 创建spring mvc工程步骤：
## 方法1 File-New-Project...-Spring-Spring MVC

## 方法2 新建一个空的Maven工程


