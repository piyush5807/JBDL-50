package com.example.testserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Take an input (name) from the FE and return "Hello " + person name
     */

    /**
     Base url : Domain name / IP + Port
     Steps to write an API
     * Define the HTTP method
     * Define the endpoint / API Path
     * Define how to take input if reqd [Optional]
     * Define the response type
     */

    // /complete/search?q=Sachin

    // Request param / Query param

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String n){
        String rs = "Hello " + n + "!!";
        return rs;
    }


    @GetMapping("/logtest")
    public String helloWorld(){
        logger.error("This is an error log");
        logger.warn("This is a warn log");
        logger.info("This is an info log");
        logger.debug("This is a debug log");
        logger.trace("This is a trace log");

        return "Hello World!!";
    }

    // localhost:8080/hello?name='67'
}
