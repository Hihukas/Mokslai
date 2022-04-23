package Cast;

public class AutomobilioDraudimas extends Draudimas{
    private final String autoNr;


    public AutomobilioDraudimas(String draudejas, String autoNr, String salis, double suma) {
        super(draudejas, salis, suma);
        this.autoNr = autoNr;
    }

    public String getAutoNr() {
        return autoNr;
    }
}
