package com.example.demosecuritydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DemoSecurityService demoSecurityService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(demoSecurityService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // issue of csrf token in any unsafe methods

        http.authorizeRequests()
                .antMatchers("/doctor/**").hasAuthority("DOCTOR_DETAILS")
                .antMatchers("/deo/**").hasAuthority("DEO_DETAILS")
                .antMatchers("/ceo/**").hasAuthority("CEO_DETAILS")
                .antMatchers("/schedule/**").hasAuthority("SCHEDULE_APPOINTMENTS")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();

    }

    @Bean
    PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
