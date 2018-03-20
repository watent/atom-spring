package com.watent.source.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib test
 *
 * @author Dylan
 * @date 2018/3/19 15:53
 */
public class Test {

    public static void main(String[] args) {

//        设置类输出路径
//        被代理class name + "$$" + 使用cglib处理的class name + "ByCGLIB" + "$$" + key的hashcode
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/ytx/ws-sys/atom-spring/spring-source/target");

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Machine.class);
        MachineAssist callback = new MachineAssist();
        enhancer.setCallback(callback);

        Machine machine = (Machine) enhancer.create();
        machine.makeCoffee();

    }
}
