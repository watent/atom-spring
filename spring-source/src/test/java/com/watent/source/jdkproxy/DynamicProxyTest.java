package com.watent.source.jdkproxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String args[]) {

        Subject real = new RealSubject();

        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new ProxyHandler(real));

        proxySubject.subjectShow();

    }
}