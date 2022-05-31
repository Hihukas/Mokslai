package lt.codeacademy;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
        TaskOne taskOne = new TaskOne();
        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(applicationProperties.getValue("jdbc.h2.url"),
                    applicationProperties.getValue("jdbc.h2.name"),
                    applicationProperties.getValue("jdbc.h2.password"));

            if (connection != null) {
                System.out.println("Connected.\n");
            }

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select vardas, pavarde from darbuotojas");
//            taskOne.printResultSet1(resultSet);

            PreparedStatement preparedStatement = connection.prepareStatement("Select d.vardas, d.pavarde, p.pavadinimas from darbuotojas d join projektas p on d.projektas_id=p.id");
            resultSet = preparedStatement.executeQuery();
//            taskOne.printResultSet2(resultSet);

            preparedStatement = connection.prepareStatement("Insert into darbuotojas values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            System.out.println("Įveskite asmens kodą:");
            int code = scanner.nextInt();
            scanner.nextLine();
            preparedStatement.setInt(1, code);

            System.out.println("Įveskite asmens vardą:");
            String name = scanner.nextLine();
            preparedStatement.setString(2, name);

            System.out.println("Įveskite asmens pavardę:");
            String surname = scanner.nextLine();
            preparedStatement.setString(3, surname);

            System.out.println("Įveskite datą:");
            preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));

            System.out.println("Įveskite asmens gimimo metus:");
            String birthDate = scanner.nextLine();
            preparedStatement.setString(5, birthDate);

            System.out.println("Įveskite pareigas:");
            String pareigos = scanner.nextLine();
            preparedStatement.setString(6, pareigos);

            System.out.println("Įveskite skyriaus pavadinimą:");
            String skyriauspav = scanner.nextLine();
            preparedStatement.setString(7, skyriauspav);

            System.out.println("Įveskite projekto id:");
            int id = scanner.nextInt();
            scanner.nextLine();
            preparedStatement.setInt(8, id);

            System.out.println("Įveskite algą:");
            int alga = scanner.nextInt();
            scanner.nextLine();
            preparedStatement.setInt(9, alga);

            preparedStatement.execute();




        } catch (SQLException e) {
            System.out.printf("SQL exception" + e.getMessage());
        }
    }

    private void printResultSet1(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("VARDAS") + " " + resultSet.getString("PAVARDE"));
            }
        } catch (SQLException e) {
            System.out.println("SQL exception" + e.getMessage());
        }
    }

    private void printResultSet2(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                System.out.println("\n" + resultSet.getString("PAVADINIMAS"));
                System.out.println(resultSet.getString("VARDAS") + " " + resultSet.getString("PAVARDE"));
            }
        } catch (SQLException e) {
            System.out.println("SQL exception" + e.getMessage());
        }
    }
}
