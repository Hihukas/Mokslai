public enum Title {
    STUDENT("Studentas"),
    TEACHER("Dėstytojas");

    private final String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
