package com.mert.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {

    @Bean("bean1")// Birinci yöntem
//    @Qualifier("bean1")
//    @Profile("dev")
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("First Bean");
    }

    @Bean
//    @Profile("test")
    //@Qualifier("Bean2")
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("Second Bean");
    }

    @Bean
    //@Primary // Bu anotasyon ile yüksek öncelik tanınacaktır.
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("Third Bean");
    }
}
