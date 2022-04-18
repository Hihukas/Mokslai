package Collections;

import java.util.LinkedList;

public class Task7 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Mama");
        list.add("Tėtis");
        list.add("Sūnus");
        list.add("Duktė");
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list);
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list);
        list.push("Pirmas");
        System.out.println(list);
        list.pop();
        System.out.println(list);


    }
}
