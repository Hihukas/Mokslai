package lt.codeacademy.generic;

public class BoxMain {
    public static void main(String[] args) {
        Box box = new Box();
        box.setObject(50);

        //Integer value = (Integer) box.getObject(); visada turi būti patikrinimas prieš castinimą
        if(box.getObject() instanceof Integer value) {
            System.out.println(value);
        }
        box.setObject("50");

        //value = (Integer) box.getObject(); ClassCastException
        if(box.getObject() instanceof String value){
            System.out.println(value);
        }

        GenericBox<Integer> genericBox = new GenericBox<>();
        genericBox.setObject(50);
        //genericBox.setObject("50"); negalima String, kadangi priima tik Integer
        System.out.println(genericBox.getObject());

        Pair<String, Integer> pairExample = new MyPair<>("Andrius", 33);
        Pair<Double, Integer> pairExample2 = new MyPair<>(55.5, 55);
        System.out.println(pairExample.getKey());
        System.out.println(pairExample.getValue());

    }
}
