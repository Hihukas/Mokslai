package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> texts = new ArrayList<>();
        texts.add("Mama");
        texts.add("Tėtis");
        texts.add("Mama");
        texts.add("Brolis");
        texts.add("Mama");
        System.out.println(texts);

        Task4 task4 = new Task4();
        System.out.println(task4.removeDuplicates(texts));

    }
    private List<String> removeDuplicates(List<String> list){
        List<String> newList = new ArrayList<>();
        for (String t: list){
            if(!newList.contains(t)){
                newList.add(t);
            }
        }
        return newList;
    }
}

