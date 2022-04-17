package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionExample {
    public static void main(String[] args) {

        //ArrayList
        ArrayList<String> names = new ArrayList<>();
        List<String> names2 = new ArrayList<>();


        //LinkedList
        LinkedList<String> cities = new LinkedList<>();
        List<String> cities2 = new LinkedList<>();

        List<String> cars = List.of();

        //kolekcijų užpildymas
        names.add("Andrius");
        names.add("Antanas");
        cities.add("Vilnius");
        cities2.add("Kaunas");


        printList(names);
        printList(names2);
        printList(cities);
        printList(cities2);
    }

    private static void printList(List<String> list) {
        System.out.printf("Listo elementų skaičius %s\n", list.size());
        System.out.println(list.contains("Andrius"));
      //  list.remove("Antanas");
      // String value = list.get(0);
       // System.out.println(value);
      //  for(int i=0; i <list.size(); i++){
       //     System.out.println(list.get(i));
      //  for (String item:list){
       //     System.out.println(item);
       // list.forEach(System.out::println);
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String value = iterator.next();
            if(value.equals("Ona")){
                iterator.remove();
            }
            System.out.println(value);
        }
        }
    }

