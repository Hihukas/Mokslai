package lt.codeacademy.generic.Tasks;

public class TaskOne {
    public static void main(String[] args) {
        Integer[] numberMass = {1, 2, 3};
        String[] wordMass = {"Hello", "World"};
        TaskOne taskOne = new TaskOne();
        taskOne.printMass(numberMass);
        taskOne.printMass(wordMass);
    }

    private <T> void printMass(T[] mass){
        for (T t: mass){
            System.out.println(t);
        }
    }
}
