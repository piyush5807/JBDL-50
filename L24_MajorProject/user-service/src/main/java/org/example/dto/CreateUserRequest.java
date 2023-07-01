package org.example.dto;

import lombok.*;
import org.example.models.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    private String email;

    @Min(18)
    private int age;


}
