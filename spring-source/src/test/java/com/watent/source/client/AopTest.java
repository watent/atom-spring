package com.watent.source.client;

import com.watent.source.aop.IntroductionInt;
import com.watent.source.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:cfg/applicationContext.xml")
public class AopTest implements ApplicationContextAware {

    public ApplicationContext context;

    //    @Autowired
    //    CommonMapper mapper;

    @Test
    public void test1() {
        HelloService service = (HelloService) context.getBean("helloServiceBean");
        service.execute();
    }

    @Test
    public void test2() {
        IntroductionInt service = (IntroductionInt) context.getBean("helloServiceBean");
        service.extend();
    }

    //    @Test
    //    public void test3() {
    //        System.out.println(mapper.queryContent(new HashMap()));
    //    }

    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        this.context = arg0;

    }

}
