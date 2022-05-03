import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith({MockitoExtension.class})
public class ExampleTest {

    @InjectMocks
    private Example example;

    @Mock
    private UserService userService;
    private UUID id;

    @BeforeEach
    void setUp(){
        id = UUID.randomUUID();
    }

    @Test
    void testCreaterNewUserWhenUserAgeIsLess(){
       boolean isUserCreated = example.createrNewUser(new User(5));

       assertFalse(isUserCreated);
    }

    @Test
        //void test_method_result(){}
    void testMethodNameWhenSomethingHappen() {
        double pow = Math.pow(2, 2);

        assertEquals(4, pow);
        assertNotNull(id);
    }
}
