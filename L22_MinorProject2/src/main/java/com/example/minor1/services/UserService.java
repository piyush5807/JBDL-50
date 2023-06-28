package com.example.minor1.services;

import com.example.minor1.models.SecuredUser;
import com.example.minor1.repositories.UserRepository;
import com.example.minor1.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByusername(username);
    }

    public SecuredUser save(SecuredUser securedUser, String userType){

        String encryptedPwd = encoder.encode(securedUser.getPassword());
        String authorities = Utils.getAuthoritiesForUser().get(userType);

        securedUser.setAuthorities(authorities);
        securedUser.setPassword(encryptedPwd);
        return this.userRepository.save(securedUser);
    }
}
