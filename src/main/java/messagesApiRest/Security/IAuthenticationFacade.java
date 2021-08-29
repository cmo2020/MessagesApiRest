package messagesApiRest.Security;

import messagesApiRest.Domain.User;
import org.springframework.security.core.Authentication;

import java.security.Principal;

public interface IAuthenticationFacade {

    String getAuthentication();
}
