package com.example.minor1.controllers;

import com.example.minor1.dtos.CreateAdminRequest;
import com.example.minor1.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin")
    public void createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest){
        adminService.create(createAdminRequest.to());
    }
}
