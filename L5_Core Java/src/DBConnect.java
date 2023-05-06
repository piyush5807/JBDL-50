import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

    public static void main(String[] args) throws SQLException {
        /**
         * Protocol :
         * http, https:  For surfing on web
         * ftp : File transfer protocol
         * smtp : For mailing purposes
         * jdbc: Java database connectivity
                 Only for relational dbs
                 jdbc:<db type>: <ip address + port number + db name>
         */

        /**
         *                          DB server / instance (IP ADDRESS + PORT Number)
         *                         /      |         |           \
         *                        DB1     DB2      DB3         DB4
         *                       / | \     | \      |         / / | | \
         *                      T1 T2 T3  T1 T2
         */

        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "");

        String sqlQuery = "CREATE TABLE person(id int, name varchar(16))";
        Statement statement = connection.createStatement();
        statement.execute(sqlQuery);

        // Maven or Gradle

        /** Why do we need maven ?
         * It's impossible to download libraries on our own and add it to the classpath
         * It helps in managing the entire project from compiling to building to execution to deployment
         * It adds all the dependencies recursively so that we can be sure of no consequences.
         */
    }
}
