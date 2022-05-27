package lt.codeacademy.postgress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgressJdbcExample {
    private static final String URL = "jdbc:postgresql://127.0.0.1/postgres";
    private static final String NAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL exception" + e.getMessage());
        }
    }
}
