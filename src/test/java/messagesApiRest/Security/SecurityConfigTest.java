package messagesApiRest.Security;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class SecurityConfigTest {

    @InjectMocks
    private SecurityConfig securityConfig;

    @Mock
    private CustomUserDetails userDetails;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    @WithMockUser
    void testConfigureBasicAuth() throws Exception {
        mockMvc
                .perform(post("/").with(httpBasic("user", "password")))
                .andExpect(status().isNotFound()).andExpect(authenticated().withUsername("user"));

    }

    @Test
    @Disabled
    void testDaoAuthenticationProvider() {
    }

    @Test
    void testEmptyPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String plainPassword = "password";
        String result = passwordEncoder.encode(plainPassword);
        assertThat(passwordEncoder.matches("", result)).isFalse();
    }

    @Test
    void testMatchesPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String result = "password";
        assertThat(result.equals("password")).isTrue();
        assertThat(passwordEncoder.matches("password", result)).isFalse();
    }

    @Test
    @Disabled
    void testConfigure() {


    }
}