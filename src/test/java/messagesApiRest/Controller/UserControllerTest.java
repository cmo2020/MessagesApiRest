package messagesApiRest.Controller;


import messagesApiRest.Domain.User;
import messagesApiRest.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    @Mock
    private User user;

    @BeforeEach
    void setUp() {

       userController = new UserController(userService);

    }

    @Test
    void testSingUp() {

        ResponseEntity<String> result = userController.singUp(user);
        verify(userService, times(1)).singUp(user);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}