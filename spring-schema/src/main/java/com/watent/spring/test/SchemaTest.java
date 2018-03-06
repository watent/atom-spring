package com.watent.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        MongoClient mongoClient = applicationContext.getBean("mongo1", MongoClient.class);
//        System.out.println(mongoClient);

        listAllSpringBeans(applicationContext);
    }

    private static void listAllSpringBeans(ApplicationContext ctx) {
        String[] beanNames = ctx.getBeanDefinitionNames();
        int allBeansCount = ctx.getBeanDefinitionCount();

        System.out.println("所有beans的数量:" + allBeansCount);
        for (String beanName : beanNames) {
            System.out.println("------");
            Class<?> beanType = ctx.getType(beanName);
            Package beanPackage = beanType.getPackage();

            Object bean = ctx.getBean(beanName);

            System.out.println("BeanName:" + beanName);
            System.out.println("Bean的类型:" + beanType);
            System.out.println("Bean所在的包:" + beanPackage);
        }
    }
}
