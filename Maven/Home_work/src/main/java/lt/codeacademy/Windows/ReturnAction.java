package lt.codeacademy.Windows;

import lt.codeacademy.Users.User;
import lt.codeacademy.Utility;

public class ReturnAction {
    private final Utility utility;

    public ReturnAction(Utility utility) {
        this.utility = utility;
    }

    public void returnAction() {
        String input;
        do {
            System.out.println("""    
                                                   
                    [1] Grįžti į pagrindinį meniu.
                    """);
            input = utility.getScanner().nextLine();
            if ("1".equals(input)) {
                switch (utility.getUser().getUserType()) {
                    case LECTOR -> {
                        LectorWindow lectorWindow = new LectorWindow(utility);
                        lectorWindow.window();
                    }
                    case STUDENT -> {
                        StudentWindow studentWindow = new StudentWindow(utility);
                        studentWindow.window();
                    }
                }
            } else {
                System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo");
                ReturnAction returnAction = new ReturnAction(utility);
                returnAction.returnAction();
            }
        } while (!input.equals("1"));
    }
}
