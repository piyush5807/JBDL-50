package com.example.demojpa.daos;

import com.example.demojpa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @Query -- To execute custom queries
     * 1. JPQL - Java persistence Query language (Keeping java objects in mind)
     * 2. Native Query - Writing queries keeping sql table in mind
     */

    // JPQL formats
//    @Query("select e from Employee e where e.name = ?1 and e.age = ?2 and e.country = ?3")
    @Query("select e from Employee e where e.name = :name and e.age = :age and e.country = :country")
//    @Query(value = "select * from employee_db e where e.emp_name = ?1 and e.age = ?2 and e.country = ?3", nativeQuery = true)
    List<Employee> get(String name, Integer age, String country);

    @Query
    List<Employee> findByNameAndAgeAndCountry(String name, Integer age, String country);


    // name --> query } Hibernate


    @Modifying
    @Transactional
    @Query(value = "update employee_db e set e.emp_name = ?1, e.age = ?2, e.country = ?3, e.years_of_exp = ?4, e.address = ?5 where e.id = ?6", nativeQuery = true)
    void update(String name, Integer age, String country, Integer yoe, String address, Integer id);


//    @Query("")
//    void update(Employee employee);
}
