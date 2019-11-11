package example;

import mypackage.WsDemoImpl;
import mypackage.WsDemoImplService;

/**
 * webservice客户端
 */
public class WebSvcClient {



    public static void main(String[] argv) {
        WsDemoImplService service = new WsDemoImplService();
        WsDemoImpl wsHelloImpl = service.getWsDemoImplPort();
        String res = wsHelloImpl.sayHello(" tom");
        System.out.println("res:"+res);

    }

}
