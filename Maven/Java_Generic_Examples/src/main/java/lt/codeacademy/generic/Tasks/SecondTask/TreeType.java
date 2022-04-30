package lt.codeacademy.generic.Tasks.SecondTask;

public enum TreeType {
    AZUOLAS("Ąžuolas"),
    BERZAS("Beržas"),
    EGLE("Eglė"),
    KADAGYS("Kadagys"),
    PUSIS("Pušis");

    private final String name;

    TreeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
