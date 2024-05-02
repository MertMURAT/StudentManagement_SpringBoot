package com.mert.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

//    @GetMapping("/hello")
//    public String sayHello(){
//        return "Hello from my first controller";
//    }

    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2(){
        return "Hello from my first controller - 2";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message){
        return "Request accepted and message is : " + message;
    }

    @PostMapping("/post-order")
    public String postOrder(
            @RequestBody Order order){
        return "Request accepted and message is : " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postOrderRecord(
            @RequestBody OrderRecord orderRecord){
        return "Request accepted and message is : " + orderRecord.toString();
    }

    // http://localhost:8080/hello/mert
    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName){
        return "MY VALUE = " + userName;
    }

    // http://localhost:8080/hello?param_name=paramvalue&param_name_2=value_2
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastName
        ){
        return "my values = " + userName + " " + userLastName;
    }

}
