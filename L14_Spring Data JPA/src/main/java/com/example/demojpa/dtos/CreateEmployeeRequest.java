package com.example.demojpa.dtos;

import com.example.demojpa.models.Employee;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeRequest {

    @Max(60)
    @Min(18)
    @NotNull
    private Integer age;

    @NotBlank
    private String name;

    private String address;

    private String country;

    private Integer yearsOfExp;

    public Employee to(){
        return Employee.builder()
                .name(this.name)
                .address(this.address)
                .age(this.age)
                .country(this.country)
                .yearsOfExp(this.yearsOfExp)
                .build();
    }

//    public static void main(String[] args) {
//
//        // builder annotation implementation
//       CreateEmployeeRequest request = CreateEmployeeRequest.builder()
//                .age(3)
//                .name("DEF")
//                .address("HSR Layout")
//                .build();

//    }
}
