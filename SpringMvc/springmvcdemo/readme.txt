# 开发环境
IDEA2019.2.3 Tomcat8.5 JDK1.8 MAVEN


# 导入代码，配置Maven, tomcat

# 编译，启动运行

# 浏览器打开：http://localhost:8088/home/index



# 版本说明
v1(2019-11-10): 简单展示一个显示hello world的界面

v2(2019-11-13)：添加两个过滤器和拦截器
在web.xml中配置过滤器；
在dispatcher-servlet.xml中配置拦截器；


浏览器打开： http://localhost:8088/home/
   控制台打印：
############FirstFilter doFilterInternal executed############
############SecFilter doFilterInternal executed############
############SecFilter doFilter after############
############FirstFilter doFilter after############

浏览器打开：http://localhost:8088/home/index
   控制台打印：
############FirstFilter doFilterInternal executed############
############SecFilter doFilterInternal executed############
************BaseInterceptor preHandle executed**********
************TestInterceptor preHandle executed**********
---------TestController executed--------
************TestInterceptor postHandle executed**********
************BaseInterceptor postHandle executed**********
************TestInterceptor afterCompletion executed**********
************BaseInterceptor afterCompletion executed**********
############SecFilter doFilter after############
############FirstFilter doFilter after############





