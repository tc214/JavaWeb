package org.tc.svc;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WsDemo {

    @WebMethod
    public String sayHello(String name);
}
