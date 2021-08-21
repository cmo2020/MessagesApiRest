package com.example.MessagesApiRest.Service;

import com.example.MessagesApiRest.Domain.User;
import com.example.MessagesApiRest.Repository.UserRepository;
import com.example.MessagesApiRest.Security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {


     private final UserRepository userRepository;
     private  PasswordConfig passwordConfig;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public  User singIn(User user){
        user.setPassword(passwordConfig.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(userName);
            builder.disabled(false);
            builder.password(user.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            throw new UsernameNotFoundException("User not found");
        }

        return builder.build();
    }


}
