package com.watent.spring.xml;

import com.watent.spring.bean.MongoClient;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;


public class MongoBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    protected Class<?> getBeanClass(Element element) {
        return MongoClient.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {

        String ip = element.getAttribute("ip");
        String port = element.getAttribute("port");

        bean.addConstructorArgValue(ip);
        bean.addConstructorArgValue(port);
    }

}