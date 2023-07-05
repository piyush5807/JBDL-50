package org.example.service;

import org.example.dto.GetUserResponse;
import org.example.models.User;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("txn-service", "test123");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        JSONObject response = restTemplate.getForObject("http://localhost:9000/user/username/" + username, JSONObject.class, headers);

        // Make the HTTP request with the specified headers
//        ResponseEntity<GetUserResponse> responseEntity = restTemplate.exchange("http://localhost:9000/user/username/" + username, HttpMethod.GET, requestEntity, GetUserResponse.class);

        // Retrieve the response body
//        GetUserResponse responseBody = responseEntity.getBody();

        return User.builder()
                .username((String)response.get("username"))
                .build();
    }
}
