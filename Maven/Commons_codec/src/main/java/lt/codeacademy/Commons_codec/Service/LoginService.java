package lt.codeacademy.Commons_codec.Service;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginService {
    private static final int MAX_RETRY = 10;
    private final Map<String, String> credentials = new HashMap<>();
    public void userRegistration(Scanner scanner){
        String userName = getUniqueUserName(scanner);
        System.out.println("Įveskite slaptažodį:");
        String password = scanner.nextLine();

        if(!isRepeatPasswordCorrect(scanner, password)){
            System.out.println("Paskyros sukurti nepavyko.");
            return;
        }
        credentials.put(userName, DigestUtils.sha512Hex(password));
        System.out.println("Registracija sėkminga.");
    }

    public void userLogin(Scanner scanner){
        System.out.println("Įveskite prisijungimo vardą:\n");
        String userName = scanner.nextLine();
        System.out.println("Įveskite slaptažodį:\n");
        String password = scanner.nextLine();

        String userPassword = credentials.get(userName);
        if(userPassword == null){
            System.out.println("Tokio vartotojo nėra.");
            return;;
        }


        if(userPassword.equals(DigestUtils.sha512Hex(password))){
            System.out.println("Neteisingas slaptažodis");
            return;
        }

        System.out.printf("Sveikiname %s prisijungus \n", userName);

    }

    private boolean isRepeatPasswordCorrect(Scanner scanner, String password){

        for(int i = 0; i < MAX_RETRY; i++){
            System.out.println("Pakartokite slaptažodžio įvedimą:");
            String repeatPassword = scanner.nextLine();
            if(!repeatPassword.equals(password)){
                System.out.println("Slaptažodžiai nesutampa.");
                continue;
            }
            return true;
        }
        return false;
    }

    private String getUniqueUserName(Scanner scanner){
        while(true){
            System.out.println("Įveskite prisijungimo vardą:");
            String newUserName = scanner.nextLine();
            String userName = credentials.get(newUserName);
            if(userName != null){
                System.out.printf("Vartotojo vardas %s egzistuoja\n", newUserName);
                continue;

            }
            return newUserName;
        }
    }
}
