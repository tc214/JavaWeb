package org.tc.svc;


import javax.jws.WebService;


/**
 * 定义webservice服务端
 * @Date 2019-11-11
 */
@WebService
public class WsDemoImpl implements WsDemo {

    public String sayHello(String name) {
        System.out.println("webservice server sayHello()" + name);
        return "hello man" + name;
    }
}
