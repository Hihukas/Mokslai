import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ExampleTest {

    private UUID id;

    @BeforeEach
    void setUp(){
        id = UUID.randomUUID();
    }
    @Test
        //void test_method_result(){}
    void testMethodNameWhenSomethingHappen() {
        double pow = Math.pow(2, 2);

        assertEquals(4, pow);
        assertNotNull(id);
    }
}
