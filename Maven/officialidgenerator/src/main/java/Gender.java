public enum Gender {

    MALE(3), FEMALE(4);

    private final int genderNumber;
    Gender(int genderNumber){
        this.genderNumber = genderNumber;
    }

    public int getGenderNumber() {
        return genderNumber;
    }
}
