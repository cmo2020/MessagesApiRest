package messagesApiRest.Controller;

import messagesApiRest.Security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private IAuthenticationFacade authenticationFacade;


    @Autowired
    public AuthenticationController(IAuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping("/currentUser")
    public String getAuthentication(){
      return authenticationFacade.getAuthentication();
    }


    }

