package com.watent.source.myproxy;

/**
 * Test
 *
 * @author Dylan
 * @date 2018/3/23 11:29
 */
public class Test {

    public static void main(String[] args) {

        Subject subject = (Subject) MyProxy.createProxyInstance(Test.class.getClassLoader(), Subject.class, new MyHandler(new RealSubject()));
        try {
            subject.subjectShow();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
