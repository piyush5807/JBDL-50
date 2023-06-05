package com.example.demojpa.controllers;

import com.example.demojpa.dtos.CreateAdminRequest;
import com.example.demojpa.dtos.CreateEmployeeRequest;
import com.example.demojpa.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/admin")
    public void createAdmin(@RequestBody @Valid CreateAdminRequest adminRequest){
        logger.info("Create Employee request received - {}", adminRequest);
        adminService.create(adminRequest.to());
        // request --> entity conversion should happen either at the controller layer or max at the service
    }
}
