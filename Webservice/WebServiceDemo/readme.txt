# 开发环境
IDEA2019.3 JDK1.8

# 运行步骤
1、发布webservice:
执行WebServicePublish.java中的main函数，如果发布成功，会在控制台打印: 发布成功
浏览器打开网址：http://localhost:8080/ws-test/hello?wsdl
网址内容不为空。

2、调用webservice
执行WebSvcClient.java中的main函数，如果调用成功，客户端的控制台会打印: res:hello man tom，服务端的控制台
会打印：webservice server sayHello() tom


# 工程创建步骤
1、使用IDEA新建一个WebService的Java工程；
2、编写WebService服务端；
3、使用IDEA通过wsdl文件生成WebService服务端代码：
Tools-WebServices-Generate Java Code from WSDL
填入url: http://localhost:8080/WebserviceDemo/hello?wsdl
4、测试调用WebService
