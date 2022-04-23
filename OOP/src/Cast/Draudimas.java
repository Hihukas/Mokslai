package Cast;

public class Draudimas {
    private final String draudejas;
    private final String salis;
    private final double suma;

    public Draudimas(String draudejas, String salis, double suma) {
        this.draudejas = draudejas;
        this.salis = salis;
        this.suma = suma;
    }

    public String getDraudejas() {
        return draudejas;
    }


    public String getSalis() {
        return salis;
    }

    public double getSuma() {
        return suma;
    }
}
