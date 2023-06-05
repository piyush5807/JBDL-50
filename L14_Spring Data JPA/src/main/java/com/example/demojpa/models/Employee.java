package com.example.demojpa.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_db")
public class Employee {

    // Generation type
    // IDENTITY --> Underlying db will generate an id, and it will not be passed in the insert query
    // AUTO --> Hibernate will generate an id and pass it in the insert query

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    private String address; // Address --> address

    private int age;

    private String country;

    private Integer yearsOfExp; // years_of_exp
}
