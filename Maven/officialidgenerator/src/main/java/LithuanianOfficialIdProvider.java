import java.time.LocalDate;

public class LithuanianOfficialIdProvider implements OfficialIdProvider {
    @Override
    public String generateOfficialId(Person person) {

        StringBuilder sb = new StringBuilder();
        LocalDate date = person.getBirthDate();

        sb.append(person.getGender().getGenderNumber())
                .append(date.getYear() % 100);

        if (date.getMonthValue() < 9) {
            sb.append(0);
        }
        sb.append(date.getMonthValue())
                .append(date.getDayOfMonth())
                .append(Skaitliukas.n);

        int lastNumber = getLastNumberOfOfficialId(sb.toString());
        sb.append(lastNumber);
        Skaitliukas.didintiVienetu();

        return sb.toString();
    }

    private int getLastNumberOfOfficialId(String code) {
        String[] split = code.split("");
        int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        int s = numbers[0] + numbers[1] * 2 + numbers[2] * 3 + numbers[3] * 4 + numbers[4] * 5 + numbers[5] * 6 + numbers[6] * 7 + numbers[7] * 8 + numbers[8] * 9 + numbers[9];
        int k = s % 11;
        if (k != 10) {
            return k;
        } else {
            s = numbers[0] * 3 + numbers[1] * 4 + numbers[2] * 5 + numbers[3] * 6 + numbers[4] * 7 + numbers[5] * 8 + numbers[6] * 9 + numbers[7] + numbers[8] * 2 + numbers[9] * 3;
            k = s % 11;
            if(k != 10){
                return k;
            }
        }

        return 0;
    }
}
