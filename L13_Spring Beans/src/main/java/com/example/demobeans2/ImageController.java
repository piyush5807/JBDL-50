package com.example.demobeans2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImageController {

    private static Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageConfig imageConfig;

//    @Autowired // useless here
    final RestTemplate restTemplate;

    // RestTemplate@214894fc

    ImageController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@RequestParam(value = "id") int id,
                           @RequestParam(value = "width", required = false, defaultValue = "200") int width,
                           @RequestParam(value = "height", required = false, defaultValue = "300") int height){

        logger.info("ImageConfig : {}", imageConfig);

        // uri and url
        String url = "https://picsum.photos/id/" + id + "/" + width + "/" + height;
//        RestTemplate restTemplate = imageConfig.getTemplate();
        // RestTemplate r = new RestTemplate();
        logger.info("RestTemplate that is autowired: {}", restTemplate);
        return restTemplate.getForObject(url, byte[].class);
    }

    // RT1 --> C1
    // RT2 --> C2

}
