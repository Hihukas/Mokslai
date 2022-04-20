package lt.codeacademy.Commons_codec;

import lt.codeacademy.Commons_codec.Service.LoginService;

import java.util.Scanner;

public class CommonsCodec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommonsCodec commonsCodec = new CommonsCodec();
        commonsCodec.selectAction(scanner);

    }

    private void menu() {
        System.out.println("""
                [1]. registruotis
                [2]. prisijungti
                [3]. exit
                 """);
    }

    private void selectAction(Scanner scanner) {
        LoginService service = new LoginService();
        String action;
        do {
            menu();
            action = scanner.nextLine();
            switch (action) {
                case "1" -> service.userRegistration(scanner);
                case "2" -> service.userLogin(scanner);
                case "3" -> System.out.println("Viso gero");
                default -> System.out.println("Tokio veiksmo nera");

            }
        }while (!action.equals("3"));

    }

}
