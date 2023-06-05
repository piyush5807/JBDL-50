package com.example.demojpa.services;

import com.example.demojpa.daos.AdminRepository;
import com.example.demojpa.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void create(Admin admin){
        adminRepository.save(admin);
    }
}
