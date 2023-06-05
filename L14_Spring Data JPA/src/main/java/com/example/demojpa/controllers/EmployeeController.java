package com.example.demojpa.controllers;

import com.example.demojpa.dtos.CreateEmployeeRequest;
import com.example.demojpa.dtos.GetEmployeesResponse;
import com.example.demojpa.models.Employee;
import com.example.demojpa.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @GetMapping("/employee/all")
    public GetEmployeesResponse getEmployees(){
        return GetEmployeesResponse.
                builder()
                .employees(employeeService.getAll())
                .build();
    }

    @GetMapping("/employee/{id}")
    public GetEmployeesResponse getEmployee(@PathVariable("id") Integer employeeId){

        Optional<Employee> employee = employeeService.getById(employeeId);
        List<Employee> employeeList = employee.isPresent() ? Arrays.asList(employee.get()) : new ArrayList<>();

        return GetEmployeesResponse.
                builder()
                .employees(employeeList)
                .build();
    }

    @PostMapping("/employee")
    public void createEmployee(@RequestBody @Valid CreateEmployeeRequest employeeRequest){
        logger.info("Create Employee request received - {}", employeeRequest);

        employeeRequest.getName();
        employeeService.create(employeeRequest.to());
        // request --> entity conversion should happen either at the controller layer or max at the service
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam("id") Integer employeeId){
        employeeService.delete(employeeId);
    }


    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable("id") int id,
                               @RequestBody CreateEmployeeRequest employeeRequest){
        employeeService.update(id, employeeRequest.to());
    }

    @GetMapping("/employee/params")
    public GetEmployeesResponse getEmployees(@RequestParam("name") String name,
                                             @RequestParam("age") int age,
                                             @RequestParam("country") String country){
        return GetEmployeesResponse.builder()
                .employees(employeeService.get(name, age, country))
                .build();
    }

    // Controller
    // RestController
    // ResponseBody -- Just converts a java object to a JSON object
}
