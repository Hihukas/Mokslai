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
    }
}
