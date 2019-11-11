package org.tc;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class MyFirstWebService {

    public String testWebService(String content){
        System.out.println("我收到了你发的信息：" + content);
        return "服务器：我转发信息给你";
    }

    public static void main(String[] args){
        //定义自己的webservice服务器发布的地址
        String address = "http://localhost:9090/MyFirstWebService"; //这个9090端口随便定义，只要不冲突即可
        //通过该方法进行发布
        Endpoint.publish(address, new MyFirstWebService());
        //打印一句话，表示一下服务器进行了开启
        System.out.println("my webservcie starting");
    }

}
