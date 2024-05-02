package com.mert.example;

import org.springframework.stereotype.Component;

//@Component // İkinci Yöntem
public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello from the MyFirstClass ==> My Var = " + myVar;
    }
}
