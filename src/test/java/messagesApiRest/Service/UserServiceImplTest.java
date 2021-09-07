package messagesApiRest.Service;

import messagesApiRest.Domain.User;
import messagesApiRest.Exception.ExceptionEmailExists;
import messagesApiRest.Repository.UserRepository;
import messagesApiRest.Security.CustomUserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;

import java.security.Principal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {



   @InjectMocks
    private UserServiceImpl userService;

   @Mock
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @BeforeEach
    void setUp() {

    userService = new UserServiceImpl(userRepository, bCryptPasswordEncoder);

    }

    @Test
    @WithMockUser
    void testCanSingUp() throws ExceptionEmailExists {
        Authentication auth = Mockito.mock(Authentication.class);
        Principal principal = Mockito.mock(Principal.class);
        CustomUserDetails userDetails = Mockito.mock(CustomUserDetails.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        SecurityContextHolder.setContext(securityContext);
        String password = "password";
        String mail = " aa@gmail.com";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Mockito.when(userRepository.findByEmail(any())).thenReturn(null);
        passwordEncoder.encode(password);
        User userSingUp = userService.singUp(user);
        verify(userRepository, times(1)).save(user);
        assertThat(password.equals("password")).isTrue();
        assertThat(passwordEncoder.matches("password", password)).isFalse();
    }

    @Test
    @WithMockUser
    void testCantSingUp() {

        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
        Assertions.assertThrows(ExceptionEmailExists.class, () -> {
            User userCreated = userService.singUp(user);
        });


    }
}