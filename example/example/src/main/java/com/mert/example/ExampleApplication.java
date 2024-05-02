package com.mert.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        var app = new SpringApplication(ExampleApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
        var run = app.run(args);

        MyFirstService myFirstService = run.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
//        System.out.println(myFirstService.getJavaVersion());
//        System.out.println(myFirstService.getOsName());
//        System.out.println(myFirstService.readProp());
        System.out.println(myFirstService.getCustomPropertyTest());
        System.out.println(myFirstService.getCustomPropertyTestInt());
        System.out.println(myFirstService.getGetCustomPropertyFromAnotherFile());
        System.out.println(myFirstService.getGetCustomPropertyFromAnotherFile2());
        System.out.println(myFirstService.getGetCustomProperty());
        System.out.println(myFirstService.getGetCustomPropertyInt());



//		MyFirstClass myFirstClass = new MyFirstClass();
//		System.out.println(myFirstClass.sayHello());
    }
}
