package com.mert.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {

    // FIELD INJECTION
//    @Autowired
//    @Qualifier("mySecondBean")
    private final MyFirstClass myFirstClass;
    @Value("Hello Mert and Students")
    private String customPropertyTest;
    @Value("62")
    private String customPropertyTestInt;
    @Value("${my.custom.property}")
    private String getCustomProperty;
    @Value("${my.custom.property.int}")
    private Integer getCustomPropertyInt;

    @Value("${my.prop}")
    private String getCustomPropertyFromAnotherFile;
    @Value("${my.prop.2}")
    private String getCustomPropertyFromAnotherFile2;


//    private Environment environment;

    public MyFirstService(
            @Qualifier("mySecondBean")
            MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory(){
        return "the dependency saying : " + myFirstClass.sayHello();
    }

    public String getCustomPropertyTest() {
        return customPropertyTest;
    }

    public String getCustomPropertyTestInt() {
        return customPropertyTestInt;
    }

    public String getGetCustomProperty() {
        return getCustomProperty;
    }

    public Integer getGetCustomPropertyInt() {
        return getCustomPropertyInt;
    }

    public String getGetCustomPropertyFromAnotherFile() {
        return getCustomPropertyFromAnotherFile;
    }

    public String getGetCustomPropertyFromAnotherFile2() {
        return getCustomPropertyFromAnotherFile2;
    }

    //CONSTRUCTER INJECTION
   // @Autowired // Bu anotasyon kullanılmadan da enjeksiyon çalışıyor.
//    public MyFirstService(@Qualifier("bean1")
//                          MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

//    // METHOD INJECTION
//    @Autowired
//    public void injectDependencies(
//            @Qualifier("bean1") MyFirstClass myFirstClass
//    ){
//        this.myFirstClass = myFirstClass;
//    }

//    // SETTER INJECTION
//    @Autowired
//    public void setMyFirstClass(
//            @Qualifier("bean1") MyFirstClass myFirstClass
//    ){
//        this.myFirstClass = myFirstClass;
//    }

//    public String getJavaVersion(){
//        return environment.getProperty("java.version");
//    }
//
//    public String getOsName(){
//        return environment.getProperty("os.name");
//    }
//
//    public String readProp(){
//        return environment.getProperty("my.custom.property");
//    }

//    @Autowired
//    public void SetEnvironment(Environment environment){
//        this.environment = environment;
//    }
}
