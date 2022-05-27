package lt.codeacademy.postgress;

import lt.codeacademy.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresTransactionExample {
    public static void main(String[] args) throws SQLException {
        ApplicationProperties instance = ApplicationProperties.getInstance();

        Connection connection = DriverManager.getConnection(instance.getValue("jdbc.postgres.url"),
                instance.getValue("jdbc.postgres.name"),
                instance.getValue("jdbc.postgres.password"));

        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement("Update public.\"Bank\" set \"name\" =? where \"id\"=?")) {
            statement.setInt(2, 1);
            statement.setString(1, "Swedbank1");
            statement.executeUpdate();

            throw new RuntimeException();


        } catch (Exception e){
            System.out.println("Visi pakeitimai bus gražinti.");
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
