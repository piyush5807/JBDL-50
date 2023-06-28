package com.example.minor1.models;

import com.example.minor1.utils.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecuredUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String authorities;

    @OneToOne(mappedBy = "securedUser")
    @JsonIgnoreProperties("securedUser")
    private Student student;

    @OneToOne(mappedBy = "securedUser")
    @JsonIgnoreProperties("securedUser")
    private Admin admin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] authorities = this.authorities.split(Constants.DELIMITER);
        return Arrays.stream(authorities)
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
