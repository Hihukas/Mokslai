package lt.codeacademy.h2;

import org.h2.engine.Database;

import java.sql.*;

public class H2JdbcExample {
    private static final String URL = "jdbc:h2:~/paskaita";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        H2JdbcExample main = new H2JdbcExample();

        // 1. Sukurti prisijungimo objektą
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        if (connection != null) {
            System.out.println("CONNECTED");
        }

        // 2. Sukurti "statement"

        Statement statement = connection.createStatement();

        // 3. Įvykdyti "statement"

        ResultSet resultSet = statement.executeQuery("SELECT * from PROJEKTAS");

        main.printResultSet(resultSet);

        // DB info
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        ResultSet tables = databaseMetaData.getTables(null, "PUBLIC", null, null);

        while(tables.next()){
            System.out.println(tables.getString(3));

        }
    }

    private void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + " " + resultSet.getString("PAVADINIMAS"));
        }
    }
}
