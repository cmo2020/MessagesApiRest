package messagesApiRest.Controller;

import messagesApiRest.Security.AuthenticationFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Mock
    private AuthenticationFacade authenticationFacade;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        authenticationController= new AuthenticationController(authenticationFacade);}

    @Test
    void testGetAuthentication() {
        String user  = "user";

            when(authenticationFacade.getAuthentication()).thenReturn(user);
            String result = authenticationController.getAuthentication();
            verify(authenticationFacade, times(1)).getAuthentication();
            assertThat(result).isEqualTo(user);



    }
}