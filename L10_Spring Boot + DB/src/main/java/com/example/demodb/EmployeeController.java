package com.example.demodb;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    // db server - 127.0.0.1 3306
    // app server - 127.0.0.1 8080

    private DBOperations dbOperations;

    public EmployeeController(){
        this.dbOperations = new DBOperations();
    }


    @GetMapping("/employee")
    public List<Employee> getEmployees() throws SQLException {
        return dbOperations.getEmployees();
    }

    @GetMapping("/employee/id/{id}")
    public Employee getEmployee(@PathVariable("id") int id) throws SQLException {
        return dbOperations.getEmployeeDynamic(id);
    }

    @PostMapping(value = "/employee")
    public void createEmployee(@RequestBody Employee employee) throws Exception {
        dbOperations.createEmployeeDynamic(employee);
    }

    @PutMapping("/employee/id/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) throws Exception {
        return null;
    }

    @PatchMapping("/employee/id/{id}")
    public Employee patchUpdateEmployee(@RequestBody Employee employee){
        return null;
    }

    @DeleteMapping("/employee")
    public Employee deleteEmployee(@RequestParam("id") int id){
        return null;
    }

}
