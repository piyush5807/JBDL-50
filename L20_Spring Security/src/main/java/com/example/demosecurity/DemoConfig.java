package com.example.demosecurity;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Karan")
                .password("$2a$10$2wFkVaM5hFkvFlXgirRAaO9rRCKau7.RRnFfA825LGhPKq3pSpqES")
                .authorities("deo")
                .and()
                .withUser("Pankaj")
                .password("$2a$10$43CPKz9.S0uDcSC9lbyX1OX0j45nldFksKlRbSnhK2moAou/5a9IO")
                .authorities("doctor")
                .and()
                .withUser("Nitish")
                .password("$2a$10$9OkRciMpB6tB2H9X5FyJcemcpAdl7zRnKN6YPK2H.vCiWNQWytJ86")
                .authorities("ceo");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/doctor/**").hasAuthority("doctor")
                .antMatchers("/deo/**").hasAuthority("deo")
                .antMatchers("/ceo/**").hasAuthority("ceo")
                .antMatchers("/schedule/**").hasAnyAuthority("deo", "doctor")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();

    }

    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}
