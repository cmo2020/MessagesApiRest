package messagesApiRest.ServiceInterface;

import messagesApiRest.Domain.User;
import org.springframework.security.core.Authentication;

import java.util.List;


public interface UserService {


    User singUp ( User user);
    void deleteUser(Long id);
     List<User> listUsers();



}
