package messagesApiRest.Service;

import messagesApiRest.Domain.User;
import messagesApiRest.Repository.UserRepository;
import messagesApiRest.Security.PasswordConfig;
import messagesApiRest.ServiceInterface.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


     private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


@Override
    public User singIn(User user){
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }





}
