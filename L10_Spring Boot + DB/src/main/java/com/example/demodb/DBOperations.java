package com.example.demodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBOperations {

    private static Logger logger = LoggerFactory.getLogger(DBOperations.class);

    private Connection connection;

    public DBOperations(@Value("${db.url}") String url,
                        @Value("${db.user}") String username,
                        @Value("${db.pass}") String password){
        try {
//            createConnection();
            this.connection = DriverManager.getConnection(url, username, password);
            createEmployeeTable();
        }catch (Exception e){
            logger.error("Exception in creating the connection with the error - {}", e);
        }
    }


    /**
     * Auto increment works on
     * 1. Last id which is inserted + 1
     * 2. Largest id seen so far + 1
     * 3. Number of records + 1
     *
     * 1
     * 2
     * 5
     * 10
     * 6
     * Option 1 - 7
     * Option 2 - 11
     * Option 3 - 6
     */

    private void createEmployeeTable() throws SQLException {
        String sql = "create table if not exists employee (id int primary key auto_increment, name varchar(30), age int)";

        Statement statement = this.connection.createStatement();
        statement.execute(sql);
    }

    // DML - Data Manipulation language (delete from, insert into, update )
    // DDL - Data definition language (create table, create index, alter table)

    // String s1 = "abc";
    // String s2 = "def";
    // String ans = s1 + s2

    // To decide the value of a primary key, generally there 2 ways:
    // 1. You use an auto incremented number
    // 2. You generate a random number (e.g Randomness can depend on multiple factors: Time + System + Random number)

    public void createEmployee(Employee employee) throws SQLException {
        // Write logic to insert an employee in the db
        // insert into employee(id, name, age) VALUES(1, "ABC", 30)

        String sql = "insert into employee (name, age) VALUES ('" + employee.getName() + "'," + employee.getAge() + ")";

        Statement statement = this.connection.createStatement();
        int result = statement.executeUpdate(sql);

        logger.info("Number of employees created - {}", result);
    }

    public void createEmployeeDynamic(Employee employee) throws SQLException{
        String sql = "insert into employee (name, age) VALUES (?,?)";

        PreparedStatement statement = this.connection.prepareStatement(sql);

        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getAge());

        int result = statement.executeUpdate();

        logger.info("Number of employees created - {}", result);
    }

    public Employee getEmployee(Integer employeeId) throws SQLException {
        String sql = "select * from employee where id = " + employeeId;

        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt(1); // rs.getInt("id")
            String name = rs.getString(2);
            Integer age = rs.getInt(3);

            return new Employee(id, name, age);
        }

        return null;

    }

    public Employee getEmployeeDynamic(Integer employeeId) throws SQLException{
        String sql = "select * from employee where id = ?";

        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, employeeId);

        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            int id = rs.getInt(1); // rs.getInt("id")
            String name = rs.getString(2);
            Integer age = rs.getInt(3);

            return new Employee(id, name, age);
        }

        return null;
    }

    public List<Employee> getEmployees() throws SQLException {
        String sql = "select * from employee";

        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<Employee> employeeList = new ArrayList<>();

        while(rs.next()){
            int employeeId = rs.getInt(1); // rs.getInt("id")
            String employeeName = rs.getString(2);
            Integer age = rs.getInt(3);

            Employee employee = new Employee(employeeId, employeeName, age);
            employeeList.add(employee);
        }

        return employeeList;
    }

    public Employee updateEmployee(Employee employee){
        // update employee set name = ?, age = ? where id = ?
        // 1 - employee.getName() , 2 - employee.getAge(), 3 - employee.getId()
        return null;
    }

    public Employee patchUpdateEmployee(Employee employee){
        // update employee set name = ?, age = ? where id = ?
        // 1 - employee.getName() , 2 - employee.getAge(), 3 - employee.getId()
        return null;
    }

    public Employee deleteEmployee(int employeeId){
        // delete from employee where id = ?
        // 1 - employeeId
        return null;
    }
}
