package com.example.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // Creating shared instance of singleton bean 'testController'

    // Retrieval of an already created bean from the IOC container is known as 'dependency injection'

    // IOC --> Phenomenon using which objects can be stored in the IOC container
    // Dependency injection --> Phenomenon using which objects can be retrieved from the IOC container

    // Component scan - Phenomenon in which spring scans all the classes in a given package to find
    //                  all the ideal component candidates

    // IOC --> @Component
    // Dependency Injection - @Autowired

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    // Field dependency injection
    // constructor dependency injection
    // setter dependency injection

//    @Autowired
    TestEntity testEntity;

    public TestController(TestService testService){
        logger.info("testService inside testController: {}", testService);
    }

   // constructor dependency injection
    @Autowired // necessary if you have multiple parameterized constructors which are taking beans as parameter
    public TestController(TestEntity testEntity){
        logger.info("testEntity inside testController: {}", testEntity);
        this.testEntity = testEntity;
    }

    /**
     * TestService
     * TestEntity
     * Error
     * Randomly
     * @return
     */

    @GetMapping("/test")
    public String sayHello(){
//        TestEntity testEntity = new TestEntity();
        logger.info("testEntity : {}", testEntity);
        return "Hello user!!";
    }

    // api 2

    // api 3

    // api 4
}
