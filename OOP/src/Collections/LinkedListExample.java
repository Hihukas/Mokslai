package Collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("test");
        // names.addFirst nėra metodo, kadangi List, o ne LinkedList. Turėtų būti:
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.addFirst(5);
        numbers.addLast(10);
    }
}
