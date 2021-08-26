package messagesApiRest.Controller;

import messagesApiRest.Domain.User;
import messagesApiRest.Service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }




    @PostMapping("/singIn")
    public ResponseEntity<User> SingIn (@Valid @RequestBody User user){
        userService.singIn(user);
        return new ResponseEntity<User>(HttpStatus.OK);

    }




    }

