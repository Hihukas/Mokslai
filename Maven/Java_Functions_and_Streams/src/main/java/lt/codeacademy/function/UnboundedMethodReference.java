package lt.codeacademy.function;

class TestClass{
    public String testMethod(String value){
        return "testMethod " + value;
    }

    public static String secondMethod(String value){
        return "Second method" + value;
    }
}

interface Transform{
    String transform(TestClass testClass, String value);

    default String testTransformMethod(String value){
        return "testTransformMethod " + value;
    }
}

interface SecondTransform{
    String getValue(String value);
}

public class UnboundedMethodReference {
    public static void main(String[] args) {
        //1. nuoroda/reference perduodant deklaraciją kvietimo metu
        Transform transform = TestClass::testMethod;
        System.out.println(transform.testTransformMethod("Value"));

        TestClass testClass = new TestClass();
        String kazkas = transform.transform(testClass, "kazkas");
        System.out.println(kazkas);

        //2. Reference iš sukurto objekto
        SecondTransform secondTransform =testClass::testMethod;
        System.out.println(secondTransform.getValue("Mano kazkokia reiksme"));

        //3. Reference, kai metodas statinis
        SecondTransform secondTransform1 = TestClass::secondMethod;
        System.out.println(secondTransform1.getValue("Nauja reiksme"));

    }
}
