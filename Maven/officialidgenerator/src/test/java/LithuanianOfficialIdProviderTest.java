import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LithuanianOfficialIdProviderTest {

    @Test
    void testId() {
        OfficialIdProvider provide = new LithuanianOfficialIdProvider();
        Person person = new Person("Andrius", LocalDate.of(1988, 12, 14), Gender.MALE);
        String s = provide.generateOfficialId(person);
        System.out.println(s);
    }
}