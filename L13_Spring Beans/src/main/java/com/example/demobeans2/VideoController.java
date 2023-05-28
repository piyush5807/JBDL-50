package com.example.demobeans2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class VideoController {

    private Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    RestTemplate restTemplate;


    // eager -- singleton
    // lazy  -- prototype

    // Bean - prototype scope

    // what are the diff ways to require something ?
    // 1. Make direct function call : For every call / API call there will be a new object
    // 2. Autowiring / DI : For every class, the object will be diff but will remain same for a given class


    @GetMapping("/random")
    public String getRandomVide(){

//        logger.info("ImageConfig : {}", imageConfig);

//        RestTemplate restTemplate = imageConfig.getTemplate();
        logger.info("RestTemplate in VideoController: {}", restTemplate);
        return String.valueOf(Math.random());
    }

    // RestTemplate@3f7daaf2
    // RestTemplate@e5da0e9
    // RestTemplate@308b27a3
}
