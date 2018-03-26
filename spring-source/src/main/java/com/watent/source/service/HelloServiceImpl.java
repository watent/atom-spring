package com.watent.source.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * HelloService Impl
 *
 * @author Dylan
 * @date 2018/3/19 14:55
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public void execute() {
        System.out.println("execute");
    }
}
