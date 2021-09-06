package messagesApiRest.Service;

import messagesApiRest.Domain.User;

import messagesApiRest.Exception.ExceptionEmailExists;
import messagesApiRest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl implements IUserService {


    private  UserRepository userRepository;

    private   BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }





    @Override
    public User singUp( User user ){
    User userNew = userRepository.findByEmail(user.getEmail());

       if(userNew!= null){

            throw new ExceptionEmailExists("Email already exists");
        }

    String encoded = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(encoded);
         return userRepository.save(user);

    }



}
