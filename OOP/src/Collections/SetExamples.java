package Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {
    public static void main(String[] args) {
        SetExamples setExamples = new SetExamples();
        setExamples.hashSetExample();
        setExamples.linkedHashSetExample();
        setExamples.treeSetExample();

    }

    private void hashSetExample(){
       /* Set<String> names = new HashSet<>();
        names.add("Vienas");
        names.add("Du");
        names.add("Trys");
        names.add("Vienas");
        System.out.println(names);*/
        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Aleksandras", 31));
        persons.add(new Person("Juozas", 30));
        persons.add(new Person("Andrius", 29));
        persons.add(new Person("Andrius", 29));
        System.out.println(persons);
    }
    private void linkedHashSetExample(){
        Set<String> names = new LinkedHashSet<>();
        names.add("Vienas");
        names.add("Du");
        names.add("Trys");
        names.add("Vienas");
        System.out.println(names);
    }
    private void treeSetExample(){
        /*Set<Integer> names = new TreeSet<>();
        names.add(9);
        names.add(5);
        names.add(2);
        names.add(3);

        System.out.println(names);*/
        Set<Person> persons = new TreeSet<>();
        persons.add(new Person("Aleksandras", 31));
        persons.add(new Person("Juozas", 30));
        persons.add(new Person("Andrius", 29));
        persons.add(new Person("Andrius", 29));

        System.out.println(persons);

    }
}
