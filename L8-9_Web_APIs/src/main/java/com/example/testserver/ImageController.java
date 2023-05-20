package com.example.testserver;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImageController {

    /**
     * input: an integer id, optional height and width
     * output: An image corresponding to the id from lorem picsum website
     */

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@RequestParam(value = "id") int id,
                           @RequestParam(value = "width", required = false, defaultValue = "200") int width,
                           @RequestParam(value = "height", required = false, defaultValue = "300") int height){

        // uri and url
        String url = "https://picsum.photos/id/" + id + "/" + width + "/" + height;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, byte[].class);
    }
}
