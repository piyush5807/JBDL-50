package com.example.demoredis.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {

    private String id;

    private String name;

    private String age;

    private Address address;

}
