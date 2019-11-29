package org.tc.service.impl;

import org.tc.service.HelloWorld;

public class HelloWorldImpl2 implements HelloWorld {


    @Override
    public void printHelloWorld() {
        System.out.println("------11111------按下HelloWorld2.printHelloWorld()-----11111111-------");

    }

    @Override
    public void doPrint() {
        System.out.println("------11111------按下HelloWorld2.doPrint()-----11111111-------");
    }
}
