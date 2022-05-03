import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LithuanianOfficialIdProviderTest {

    @Test
    void testGenerateOfficialIdWhenLengthIsCorrect() {
        OfficialIdProvider provider = new LithuanianOfficialIdProvider();
        String id = provider.generateOfficialId(new Person("Andrius", LocalDate.of(1965, 5, 12), Gender.MALE));

        assertNotNull(id);
        assertEquals(11, id.length());
    }

    @Test
    void testGenerateOfficialIdWhenGenderIsCorrect() {
        OfficialIdProvider provider = new LithuanianOfficialIdProvider();
        String id = provider.generateOfficialId(new Person("Andrius", LocalDate.of(1965, 5, 12), Gender.MALE));

        assertNotNull(id);
        assertEquals(Gender.MALE.getGenderNumber(), Integer.parseInt(id.substring(0, 1)));
    }

    @Test
    void testGenerateOfficialIdWhenYearIsCorrect() {
        OfficialIdProvider provider = new LithuanianOfficialIdProvider();
        String id = provider.generateOfficialId(new Person("Andrius", LocalDate.of(1965, 5, 12), Gender.MALE));

        assertNotNull(id);
        assertEquals(65, Integer.parseInt(id.substring(1, 3)));
    }

    @Test
    void testGenerateOfficialIdWhenMonthIsCorrect() {
        OfficialIdProvider provider = new LithuanianOfficialIdProvider();
        String id = provider.generateOfficialId(new Person("Andrius", LocalDate.of(1965, 5, 12), Gender.MALE));

        assertNotNull(id);
        assertEquals("05", id.substring(3, 5));
    }

    @Test
    void testGenerateOfficialIdWhenDayIsCorrect() {
        OfficialIdProvider provider = new LithuanianOfficialIdProvider();
        String id = provider.generateOfficialId(new Person("Andrius", LocalDate.of(1965, 5, 12), Gender.MALE));

        assertNotNull(id);
        assertEquals(12, Integer.parseInt(id.substring(5, 7)));
    }
}