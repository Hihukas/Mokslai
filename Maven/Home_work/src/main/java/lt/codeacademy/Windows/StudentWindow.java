package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

public class StudentWindow extends AbstractWindow {
    private final User user;
    private final Utility utility;

    public StudentWindow(User user, Utility utility) {
        this.user = user;
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        System.out.println("""
                                
                Pasirinkite norimą atlikti veiksmą:
                [1] - Laikyti egzaminą.
                [2] - Egzaminų rezultatai.
                [3] - Atsijungti ir grįžti į pagrindinį meniu.
                """);
        String input = utility.getScanner().nextLine();
        switch (input) {
            case "1" -> {
                ExamsWindow examsWindow = new ExamsWindow(user, this, false, utility);
                examsWindow.window();
            }
            case "2" -> {
                OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(user, utility);
                oneStudentExamsResultsWindow.window();
            }
            case "3" -> {
                MainWindow mainWindow = new MainWindow(utility);
                mainWindow.window();
            }
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
                StudentWindow studentWindow = new StudentWindow(user, utility);
                studentWindow.window();
            }
        }
    }
}
