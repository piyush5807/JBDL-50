package com.example.demobeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

//    @Value("${prop.bot.name}")
    private String name;

    // The way instance attributes are declared in java is not same when we
    // autowire the attributes value in spring

    public ValueController(@Value("${prop.bot.name}") String name) {
        System.out.println("name = " + name);
        helper();
//        this.name = botName;
//        System.out.println("updated name = " + this.name);
    }

    public void helper(){
        System.out.println("Inside helper function: name = " + this.name);
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello User! This is " + this.name + ", how can I help you ??";
    }
}
