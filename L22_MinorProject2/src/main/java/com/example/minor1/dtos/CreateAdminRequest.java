package com.example.minor1.dtos;

import com.example.minor1.models.Admin;
import com.example.minor1.models.SecuredUser;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAdminRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public Admin to() {

        return Admin.builder()
                .name(this.name)
                .email(this.email)
                .securedUser(
                        SecuredUser.builder()
                                .username(this.username)
                                .password(this.password)
                                .build()
                )
                .build();
    }
}
