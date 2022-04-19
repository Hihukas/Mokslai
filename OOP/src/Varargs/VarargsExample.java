package Varargs;

public class VarargsExample {
    public static void main(String[] args) {
        VarargsExample example = new VarargsExample();
        example.print(5,"Aleksandras", "5", "Teta");

    }
   /* private void print(String name){

    }
    private void print(String name, String secondName){

    }*/

    private void print(int a, String b, String... names){
        for(String name: names){
            System.out.println(name);
        }
    }
}
