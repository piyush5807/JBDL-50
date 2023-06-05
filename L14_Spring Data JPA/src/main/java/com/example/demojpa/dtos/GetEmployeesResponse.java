package com.example.demojpa.dtos;

import com.example.demojpa.models.Employee;
import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeesResponse {

    List<Employee> employees;
}
