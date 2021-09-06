package messagesApiRest.Service;

import messagesApiRest.Domain.User;
import messagesApiRest.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;

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



    }

    @Test
    @WithMockUser
    void testCanSingUp() {

        String password = "password";
        String mail = " aa@gmail.com";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Mockito.when(userRepository.findByEmail(any())).thenReturn(null);
        passwordEncoder.encode(password);
        User userSingUp = userService.singUp(user);
        assertThat(password.equals("password")).isTrue();
        assertThat(passwordEncoder.matches("password", password)).isFalse();
        verify(userRepository, times(1)).save(user);
    }
}