package lt.codeacademy.generic;

public class BoxMain {
    public static void main(String[] args) {
        Box box = new Box();
        box.setObject(50);

        //Integer value = (Integer) box.getObject(); visada turi būti patikrinimas prieš castinimą
        if (box.getObject() instanceof Integer value) {
            System.out.println(value);
        }
        box.setObject("50");

        //value = (Integer) box.getObject(); ClassCastException
        if (box.getObject() instanceof String value) {
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

        //Raw tipas (nerekomenduojama)
        GenericBox rawGenericBox = new GenericBox();
        rawGenericBox.setObject(50);
        rawGenericBox.setObject("50");

        //Integer v =(Integer) rawGenericBox.getObject(); ClassCastException

        BoxMain main = new BoxMain();

        main.testGenericMethod("test");
        main.testGenericMethod(50);
        main.testGenericMethod(true);
        main.testGenericMethod(genericBox);

        Integer integer = main.testGenericMethod2(50);

        String o = main.testGenericMethod3();


        Pair<String, String> p1 = new MyPair<>("As", "Tu");
        Pair<String, String> p2 = new MyPair<>("TU", "jis");
        System.out.println(PairComperator.compare(p1, p2));
    }

    private <E> void testGenericMethod(E type) {

    }

    private <E> E testGenericMethod2(E e) {
        return e;
    }

    private <K, V> void testGenericMethod3(K k, V v) {

    }

    private <E> E testGenericMethod3() {
        return null;
    }
}
