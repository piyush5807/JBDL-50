package com.example.minor1.dtos;

import com.example.minor1.models.Admin;
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

    public Admin to() {

        return Admin.builder()
                .name(this.name)
                .email(this.email)
                .build();
    }
}
