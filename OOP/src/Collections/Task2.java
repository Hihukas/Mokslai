package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Task2 task2 = new Task2();
        while(list.size() == 0){task2.fillUpList(scanner, list);}
    }
    private void fillUpList(Scanner scanner,List<String> list){
        for (int i = 0; i < 5; i++) {
                System.out.println("Įveskite žodį:");
                String text = scanner.next();
                if(list.contains(text)){
                    System.out.println("Toks žodis jau yra.");
                    continue;
                }
                list.add(text);

                //list.contains(text);
                //System.out.println("Toks žodis jau yra. Įveskite kitą žodį:");

            if (list.size() == 5) {
                list.forEach(System.out::println);
                list.clear();
            }
        }
    }
}
