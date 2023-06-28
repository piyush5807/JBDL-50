package com.example.demosecuritydb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoSecurityRepository extends JpaRepository<DemoUser, Integer> {

    DemoUser findByusername(String u);
}
