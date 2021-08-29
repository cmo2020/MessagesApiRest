package messagesApiRest.Service;

import lombok.NoArgsConstructor;
import messagesApiRest.Security.CustomUserDetails;
import messagesApiRest.Domain.User;
import messagesApiRest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User name not found:"+ userName);
        }
        return new CustomUserDetails(user);
    }



    }
