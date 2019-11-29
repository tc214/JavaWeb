package org.tc.service.impl;

import org.tc.service.HelloWorld;

public class HelloWorldImpl1 implements HelloWorld {


    @Override
    public void printHelloWorld() {
        System.out.println("------11111------按下HelloWorld1.printHelloWorld()-----11111111-------");

    }

    @Override
    public void doPrint() {
        System.out.println("------11111------按下HelloWorld1.doPrint()-----11111111-------");
    }
}
