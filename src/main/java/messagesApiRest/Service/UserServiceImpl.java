package messagesApiRest.Service;

import messagesApiRest.Domain.User;

import messagesApiRest.Exception.ExceptionEmailExists;
import messagesApiRest.Repository.UserRepository;
import messagesApiRest.ServiceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {


    private final UserRepository userRepository;

    private final   BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;


    }

    @Override
    public User singUp( User user ){

    boolean userEmailExists = userRepository.findByEmail(user.getEmail())
            .isPresent();
       if(userEmailExists){

            throw new ExceptionEmailExists("Email already exists");
        }

    String encoded = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(encoded);
         return userRepository.save(user);

    }


    @Override
    public void deleteUser(Long id)  {
        User user = userRepository.getUserById(id);
       userRepository.delete(user);
    }



    public User findByUserName(String userName){

        return userRepository.findByUserName(userName);

    }

    public Optional<User> findByEmail(String email){
       return userRepository.findByEmail(email);


    }





    }
