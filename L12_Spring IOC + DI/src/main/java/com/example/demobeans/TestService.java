package com.example.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static Logger logger = LoggerFactory.getLogger(TestService.class);


    public TestService() {
        logger.info("TestService object created: {}", this);
    }
}


// com.example.demobeans.TestService@6754ef00 - created
//