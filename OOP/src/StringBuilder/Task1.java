package StringBuilder;

public class Task1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String text1 = "Liepa";
        String text2 = "Antradienis";
        sb.append(text1).append(text2);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.delete(0, 5);
        sb.delete(4, 6);
        sb.delete(5, 7);
        sb.delete(6, 7);
        System.out.println(sb);
        sb.replace(3, 6, "2018");
        System.out.println(sb);
        sb.insert(3, "om ");
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
