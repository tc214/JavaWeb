package org.tc.svc;

import javax.xml.ws.Endpoint;


/**
 * 发布webservice
 */
public class WebServicePublish {
    public static void main(String[] args) {
        String address = "http://localhost:8080/WebserviceDemo";
        Endpoint.publish(address, new  WsDemoImpl());
        System.out.println("发布成功");
    }
}
