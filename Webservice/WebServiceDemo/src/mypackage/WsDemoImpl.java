
package mypackage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WsDemoImpl", targetNamespace = "http://svc.tc.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsDemoImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://svc.tc.org/", className = "mypackage.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://svc.tc.org/", className = "mypackage.SayHelloResponse")
    @Action(input = "http://svc.tc.org/WsDemoImpl/sayHelloRequest", output = "http://svc.tc.org/WsDemoImpl/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
