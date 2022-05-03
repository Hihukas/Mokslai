import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
       // MockitoAnnotations.openMocks(this);
        //UserService userService = Mockito.mock(UserService.class);
        //example = new Example(userService);

        id = UUID.randomUUID();
    }

    @Test
    void testCreateNewUserWhenUserServiceThrowException(){
        doThrow(IllegalArgumentException.class).when(userService).getUsername();

        assertThrows(IllegalArgumentException.class, () -> example.createrNewUser(null));
    }

    @Test
    void testCreateNewUser(){
        when(userService.getUsername()).thenReturn("DummyName");

        boolean isUserCreated = example.createrNewUser(new User(12));

        assertTrue(isUserCreated);
    }

    @Test
    void testCreateNewUserWhenUserNameIsNull(){
        when(userService.getUsername()).thenReturn(null);
        boolean isUserCreated = example.createrNewUser(new User(11));

        assertFalse(isUserCreated);
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
