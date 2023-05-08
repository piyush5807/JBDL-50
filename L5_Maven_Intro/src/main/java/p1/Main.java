package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "");

        String sqlQuery = "CREATE TABLE person(id int, name varchar(16))";
        Statement statement = connection.createStatement();

        statement.execute(sqlQuery);
    }

    // Lifecycle or Phase

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return Math.abs(a - b);
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        return a / b;
    }

    public int power(int a, int b){
        return (int)Math.pow(a, b);
    }



}
