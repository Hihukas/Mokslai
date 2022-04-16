package StringBuilder;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tekstas");
        sb.reverse();

        String t = sb.toString();
        System.out.println(sb);
        System.out.println(t);

        String text = "Labas vakaras Jonai";
        if(true){
            text+="!";
        }
        System.out.println(text);

        StringBuilder sb2 = new StringBuilder("Labas vakaras Jonai");
        sb2.append("!");
        System.out.println(sb2);
    }
}
