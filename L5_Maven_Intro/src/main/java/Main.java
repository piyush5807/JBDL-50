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

}
