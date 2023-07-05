package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Utils;
import org.example.dto.CreateUserRequest;
import org.example.dto.GetUserResponse;
import org.example.models.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createUser(@RequestBody @Valid CreateUserRequest userRequest) throws JsonProcessingException {
        userService.create(Utils.convertUserCreateRequest(userRequest));
    }

    // User

    @GetMapping("/user")
    public GetUserResponse getUser() throws Exception {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        user = userService.get(user.getId());

        return Utils.convertToUserResponse(user);
    }

    // Service / System
    @GetMapping(value = "/user/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUserResponse getByUsername(@PathVariable("username") String username) throws Exception {
        User user = (User) userService.loadUserByUsername(username);
        return Utils.convertToUserResponse(user);
    }
}
