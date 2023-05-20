package com.example.testserver;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    /**
     * CRUD operations that can handle employee lifecycle
     */
    private HashMap<Integer, Employee> employeeHashMap = new HashMap<>();

    // You can not have 2 same APIs in the entire application (ip + port)
    // Same API = Same path + Same HTTP method

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return this.employeeHashMap.values().stream().collect(Collectors.toList());
    }


    // Path variable / path param

    // http://localhost:9090/employee/id/2  -- using path variable
    // http://localhost:9090/employee?id=2  -- using request params

    @GetMapping("/employee/id/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        return this.employeeHashMap.get(id);
    }

    @PostMapping(value = "/employee")
    public void createEmployee(@RequestBody Employee employee) throws Exception {

        if(employee.getId() == null){
            throw new Exception("Employee id cannot be null");
        }

        this.employeeHashMap.put(employee.getId(), employee);
    }

    /*
            Earlier :
            Employee - 1, Name - ABC, Age - 30

            Put
            Employee - 1, Name = DEF, Age = empty

            Data - {1, DEF, null}

            Patch
            Employee - 1, Name = DEF

            Data - {1, DEF, 30}
     */

    @PutMapping("/employee/id/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) throws Exception {

        if(employee.getId() == null || !this.employeeHashMap.containsKey(employee.getId())){
            throw new Exception("Not a valid employee, updation failed....");
        }

        return this.employeeHashMap.put(employee.getId(), employee);
    }

    @PatchMapping("/employee/id/{id}")
    public Employee patchUpdateEmployee(@RequestBody Employee employee){

        Employee employeeFromMap = this.employeeHashMap.get(employee.getId());

        if(employee.getAge() != null){
            employeeFromMap.setAge(employee.getAge());
        }

        if(employee.getName() != null){
            employeeFromMap.setName(employee.getName());
        }

        return this.employeeHashMap.put(employee.getId(), employeeFromMap);
    }

    @DeleteMapping("/employee")
    public Employee deleteEmployee(@RequestParam("id") int id){
        return this.employeeHashMap.remove(id);
    }


}
