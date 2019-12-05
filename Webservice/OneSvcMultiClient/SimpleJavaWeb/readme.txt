# 开发环境
IDEA2019.3 JDK1.8 Tomcat8.5

# 运行步骤
1、使用IDEA打开工程

2、配置Tomcat
url,port等；
注意：Deployment-Application context:可以设置为"/",否则打开浏览器预览时，需要加上该字段


3、运行
运行成功后，浏览器会自动打开：
http://localhost:8080
端口是配置Tomcat时设置的端口





# 创建一个简单Java Web工程步骤
1、使用IDEA新建一个Java web工程；
File-New-Project-Java-Web Application - Java EE- JavaEE Application

2、配置Web
如果工程没有自动生成web文件夹，需要手动添加。
手动添加：
工程右键选择: Add Framwork Support...- Java EE- JavaEE Application

3、创建一个Servlet，并在web.xml中配置该servlet


注意：只能在ie下测试调用WebService




