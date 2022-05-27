package lt.codeacademy.postgress;

import lt.codeacademy.ApplicationProperties;

import java.sql.*;

public class PostgresJdbcExample {
    public static void main(String[] args) {
        PostgresJdbcExample example = new PostgresJdbcExample();

        try {
            Connection connection = DriverManager.getConnection(ApplicationProperties.getInstance().getValue("jdbc.postgres.url"),
                    ApplicationProperties.getInstance().getValue("jdbc.postgres.name"),
                    ApplicationProperties.getInstance().getValue("jdbc.postgres.password"));

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.\"Bank\"");
            example.printResult(resultSet);

            // insert example
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.\"Bank\" values (?, ?, ?, ?)");

            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Šiauliai bankas");
            preparedStatement.setString(3, "Š");
            preparedStatement.setInt(4, 5);
//            preparedStatement.execute();

            // update example
            preparedStatement = connection.prepareStatement("UPDATE public.\"Bank\" set\"name\"=? where \"id\"=?");
            preparedStatement.setInt(2, 5);
            preparedStatement.setString(1, "Šiauliai Bank");
//            preparedStatement.execute();

            // delete example
            preparedStatement = connection.prepareStatement("Delete from public.\"Bank\" where \"id\" = ?");
            preparedStatement.setInt(1, 5);
            preparedStatement.execute();

            example.updateValuesInResultSet(connection);
        } catch (SQLException e) {
            System.out.println("SQL exception" + e.getMessage());
        }
    }

    private void printResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getString("vat_code") + " " + resultSet.getInt("registration_code"));
        }
    }

    private void updateValuesInResultSet(Connection connection) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.\"Bank\"");

        while (resultSet.next()) {
            if (resultSet.getString("name").equals("Swedbank")) {
                resultSet.updateString("name", resultSet.getString("name").toUpperCase());
                resultSet.updateRow();
            }

        }
    }
}
