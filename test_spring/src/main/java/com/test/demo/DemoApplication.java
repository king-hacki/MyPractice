package com.test.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.awt.*;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("composing.xml");
        log.info("All beans in context : " + Arrays.toString(context.getBeanDefinitionNames()));

        // retrieve configured instance
        PetStoreServiceImpl pet = context.getBean("petStore", PetStoreServiceImpl.class);
        log.info("PetStoreServiceImpl bean : " + pet);

        //  the most flexible variant
        GenericApplicationContext genericContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(genericContext).loadBeanDefinitions("composing.xml");
        genericContext.refresh();


    }

}
