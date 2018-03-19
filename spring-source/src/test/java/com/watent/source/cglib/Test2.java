package com.watent.source.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * cglib test
 *
 * @author Dylan
 * @date 2018/3/19 15:53
 */
public class Test2 {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Machine.class);
        enhancer.setCallbackFilter(new CustomFilter());

        //这里定义了3个增强，3个回掉
        Callback c0 = NoOp.INSTANCE;
        Callback c1 = new FixValueCallback();
        Callback c2 = new MachineAssist();

        Callback[] callbacks = new Callback[]{c0, c1, c2};
        enhancer.setCallbacks(callbacks);

        Machine cglibProxy = (Machine) enhancer.create();
        cglibProxy.makeOrangeJuice();
    }
}
