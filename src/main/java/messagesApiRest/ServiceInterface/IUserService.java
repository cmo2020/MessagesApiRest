package messagesApiRest.ServiceInterface;

import messagesApiRest.Domain.User;
import org.springframework.security.core.Authentication;

import java.util.List;


public interface IUserService {


    User singUp ( User user);
    void deleteUser(Long id);




}
