package com.example.minor1.dtos;

import com.example.minor1.models.SecuredUser;
import com.example.minor1.models.Student;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private Integer age;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public Student to(){
        return Student.builder()
                .name(this.name)
                .email(this.email)
                .age(this.age)
                .securedUser(
                        SecuredUser.builder()
                                .username(this.username)
                                .password(this.password)
                                .build()
                )
                .build();
    }
}
