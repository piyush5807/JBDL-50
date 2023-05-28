package com.example.demobeans2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ImageConfig {

    // singleton scope -- bean will be created on the application startup and will be shared and singleton across all the classes
    // prototype scope -- bean will be created when it's required and may not be on the application startup

//    @Autowired
//    VideoController videoController;


    private static Logger logger = LoggerFactory.getLogger(ImageConfig.class);

    public ImageConfig(){
        logger.info("ImageConfig Object created: {}", this);
    }


    @Bean // if this is a singleton bean ==> not go inside the function
    @Scope("prototype")
    public RestTemplate getTemplate(){ // static or instance/member function
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Inside getTemplate function, creating an object of restTemplate: {}", restTemplate);
        return restTemplate;
    }

    // Img -- RestTemplate@6548bb7d           API call 1 - RestTemplate@6548bb7d ,
    // Video -- RestTemplate@159e366          API call 1 - 159e366
}
