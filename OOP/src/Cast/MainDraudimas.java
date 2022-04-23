package Cast;

public class MainDraudimas {
    public static void main(String[] args) {
        Draudimas tpvca = new TPVCADraudimas("Andrius Baltrūnas", "LGH999", "LT", 198.9);
        Draudimas kasko = new KaskoDraudimas("Jonas Jonaitis", "KGT714", "LT", 250.9,995.8);

        System.out.printf("Draudėjas: %s, suma: %s\n", tpvca.getDraudejas(), tpvca.getSuma());
        System.out.printf("Draudėjas: %s, suma: %s\n", kasko.getDraudejas(), kasko.getSuma());

        System.out.println(((AutomobilioDraudimas) tpvca).getAutoNr());
        System.out.println(((AutomobilioDraudimas) kasko).getAutoNr());

        System.out.println(((KaskoDraudimas) kasko).getFrancize());
    }
}
