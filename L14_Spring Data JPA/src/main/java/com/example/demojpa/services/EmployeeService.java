package com.example.demojpa.services;

import com.example.demojpa.daos.EmployeeRepository;
import com.example.demojpa.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void create(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> getById(Integer employeeId){
        return employeeRepository
                .findById(employeeId);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public void delete(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void update(Integer id, Employee employee) {
        employee.setId(id);
        employeeRepository.save(employee);
//        employeeRepository.update(
//                employee.getName(),
//                employee.getAge(),
//                employee.getCountry(),
//                employee.getYearsOfExp(),
//                employee.getAddress(),
//                id
//        );
    }

    public List<Employee> get(String name, int age, String country) {
        return employeeRepository.findByNameAndAgeAndCountry(name, age, country);
    }

    // select * from employee where id = <employee_id>
}
