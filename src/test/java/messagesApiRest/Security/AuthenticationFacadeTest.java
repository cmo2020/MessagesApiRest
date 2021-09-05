package messagesApiRest.Security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;


import java.security.Principal;

import static org.mockito.Mockito.*;

class AuthenticationFacadeTest {


    @Mock
    private CustomUserDetails customUserDetails;

    @BeforeEach
    protected void setUp() {
        customUserDetails = new CustomUserDetails();
    }

    @Test
    @WithMockUser(username = "user", roles = { "user" })
    void testGetAuthentication() {
        Authentication auth = Mockito.mock(Authentication.class);
        Principal principal = Mockito.mock(Principal.class);
        CustomUserDetails userDetails = Mockito.mock(CustomUserDetails.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(auth);
        SecurityContextHolder.setContext(securityContext);

       assertThat(principal.getName()).isEqualTo(userDetails.getUsername());

    }

    @Test
    @WithMockUser(username = "user", roles = { "user" })
    void testUnauthorized() {
        Authentication auth = Mockito.mock(Authentication.class);
        Principal principal = Mockito.mock(Principal.class);
        CustomUserDetails userDetails = Mockito.mock(CustomUserDetails.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication().getPrincipal()).thenReturn(principal);
        SecurityContextHolder.setContext(securityContext);


    }
}