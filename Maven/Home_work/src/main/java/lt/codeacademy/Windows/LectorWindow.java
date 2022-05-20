package lt.codeacademy.Windows;

import lt.codeacademy.Utility;

public class LectorWindow extends AbstractWindow {
    private final Utility utility;

    public LectorWindow(Utility utility) {
        this.utility = utility;
    }

    @Override
    public void window() throws Exception {
        System.out.println("""
                
                Pasirinkite norimą atlikti veiksmą:
                [1] - Egzaminų rezultatai.
                [2] - Sukurti testo egzaminą.
                [3] - Testo egzaminų papildymas klausimais.
                [4] - Atsijungti ir grįžti į pagrindinį meniu.
                """);
        String input = utility.getScanner().nextLine();
        switch (input) {
            case "1" -> {
                StudentsExamsResultsWindow studentsExamsResultsWindow = new StudentsExamsResultsWindow(utility);
                studentsExamsResultsWindow.window();
            }
            case "2" -> {
                ExamsCreateWindow examsCreateWindow = new ExamsCreateWindow(utility);
                examsCreateWindow.window();
            }
            case "3" -> {
                ExamsWindow examsWindow = new ExamsWindow(this, true, utility);
                examsWindow.window();
            }
            case "4" -> {
                MainWindow mainWindow = new MainWindow(utility);
                mainWindow.window();
            }
            default -> {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.\n");
                LectorWindow lectorWindow = new LectorWindow(utility);
                lectorWindow.window();
            }
        }
    }
}

