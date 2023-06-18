package com.example.demoredis.dto;

import com.example.demoredis.model.Address;
import com.example.demoredis.model.Person;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonCreateRequest {

    @NotBlank
    private String name;

    private String age;

    private Address address;

    public Person to(){
        return Person.builder()
                .name(this.name)
                .age(this.age)
                .address(this.address)
                .id(UUID.randomUUID().toString())
                .build();
    }
}
