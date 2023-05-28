package com.example.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
public class TestEntity {

    private static Logger logger = LoggerFactory.getLogger(TestEntity.class);

    // For IOC to work properly, there needs to be either a default constructor or a parameterized constructor where
    // parameters need to be bean itself

    private String name;
    private Integer id;

    public TestEntity(){
        logger.info("TestEntity created: {}", this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // com.example.demobeans.TestEntity@1e53135d - startup

    // null - injected one

}
