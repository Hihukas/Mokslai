package StringBuilder;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task2 task2 = new Task2();
        task2.isPalindrome(scanner);

    }
    private void isPalindrome (Scanner scanner){
        System.out.println("Įveskite tekstą:");
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String text1 = sb.toString().toLowerCase();
        String text2 = String.valueOf(sb.reverse()).toLowerCase();
        if (text1.equals(text2)) {
            System.out.println("Polindromas");
        } else{
            System.out.println("Ne polindromas.");
        }

    }
}
