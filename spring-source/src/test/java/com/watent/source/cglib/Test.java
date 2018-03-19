package com.watent.source.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib test
 *
 * @author Dylan
 * @date 2018/3/19 15:53
 */
public class Test {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Machine.class);
        MachineAssist callback = new MachineAssist();
        enhancer.setCallback(callback);

        Machine machine = (Machine) enhancer.create();
        machine.makeCoffee();

    }
}
