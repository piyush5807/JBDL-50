package com.example.demosecuritydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DemoSecurityService implements UserDetailsService {

    @Autowired
    DemoSecurityRepository demoSecurityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get the data from some persistent store
        return demoSecurityRepository.findByusername(username);
    }
}
