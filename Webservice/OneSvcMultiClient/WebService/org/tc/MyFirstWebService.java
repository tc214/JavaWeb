
package org.tc;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MyFirstWebService", targetNamespace = "http://tc.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MyFirstWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "testWebService", targetNamespace = "http://tc.org/", className = "org.tc.TestWebService")
    @ResponseWrapper(localName = "testWebServiceResponse", targetNamespace = "http://tc.org/", className = "org.tc.TestWebServiceResponse")
    @Action(input = "http://tc.org/MyFirstWebService/testWebServiceRequest", output = "http://tc.org/MyFirstWebService/testWebServiceResponse")
    public String testWebService(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
