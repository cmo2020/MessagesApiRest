package messagesApiRest.Service;

import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.Role;
import messagesApiRest.Domain.User;
import messagesApiRest.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @InjectMocks
    private CustomUserDetailsService userService;

    @Mock
    private UserRepository userRepository;



    @Test
    void testCantLoadUserByUsername() {
        String username = "user";
        Set<Message> messageSet = new HashSet<>();
        User user = new User(1L, "user", "name", "lastname",
                "aa@gmail.com", "address", 5000, "Arg", "cba",
                "password", Role.USER, messageSet);
        Mockito.when(userRepository.findByUserName(username)).thenReturn(null);
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            UserDetails userCreated = userService.loadUserByUsername(username);
        });
    }





}