package lt.codeacademy.Commons_codec;

import java.util.Scanner;

public class CommonsCodec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommonsCodec commonsCodec = new CommonsCodec();
        commonsCodec.menu();
        commonsCodec.selectAction(scanner);

    }
    private void menu(){
        System.out.println("""
                [1]. registruotis
                [2]. prisijungti
                 """);
    }

    private void selectAction(Scanner scanner){
        String action = scanner.nextLine();
        switch (action){
            case "1" -> ;
            case "2" -> ;
            default -> System.out.println("Tokio veiksmo nera");
        }
    }

}
