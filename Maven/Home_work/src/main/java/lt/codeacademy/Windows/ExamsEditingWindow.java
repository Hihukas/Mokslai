package lt.codeacademy.Windows;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Exams.Exam;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ExamsEditingWindow extends AbstractWindow {
    @Override
    public void window() throws Exception {
    }

    private void chooseAction(Scanner scanner, User user) throws Exception {
        System.out.println("""
                Testo egzaminas išsaugotas.
                                
                [1] Grįžti į dėstytojo meniu.
                [2] Kurti naują testo egzaminą.
                """);

        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                TeacherWindow teacherWindow = new TeacherWindow(user);
                teacherWindow.window();
            }
            case "2" -> {
                ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(user);
                examsCreateWindow.window();
            }
            default -> System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
        }
    }
}

