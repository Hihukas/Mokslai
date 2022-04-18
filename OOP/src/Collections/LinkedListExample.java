package Collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("test");
        // names.addFirst nėra metodo, kadangi List, o ne LinkedList. Turėtų būti:
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(5);
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        Integer poll = numbers.poll();// jei elemento nėra, gražina null
        Integer pop = numbers.pop();// jei nėra elemento, exception

        numbers.
    }
}
