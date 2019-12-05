package org.test;

import org.junit.Test;
import org.tc.MyFirstWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 推荐使用QName的调用方式，这种方式只需保留MyFirstWebService一个类
 */
public class MyTestQNameWebService {

    @Test
    public void test() throws MalformedURLException {
        //创建一个连接（地址对应的就是webservice服务器中的地址）
        URL wsdlDocumentLocation = new URL("http://localhost:9090/MyFirstWebService?wsdl");
        //这个参数，主要是根据我们设定的webService的接口来进行的 第一个参数对应MyFirstWebService中的targetNamespace
        QName serviceName = new QName("http://tc.org/","MyFirstWebServiceService");
        Service ws = Service.create(wsdlDocumentLocation , serviceName );
        //获取到调用的对象内容
        MyFirstWebService port = ws.getPort(MyFirstWebService.class);
        //方法的调用
        String result = port.testWebService("my name is scw");
        System.out.println(result);
    }
}
