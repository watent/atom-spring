package com.watent.source.controller;

import com.watent.source.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * hello
 *
 * @author Dylan
 * @date 2018/3/14 15:11
 */
@Controller
public class HelloController {

    @Resource
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public Map<String, Object> hello() {

        Map<String, Object> response = new HashMap<>();

        helloService.execute();

        response.put("hello", "world");
        return response;
    }

}
