package messagesApiRest.Controller;

import messagesApiRest.Domain.User;
import messagesApiRest.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@RestController
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }



    @PostMapping("/singUp")
    public ResponseEntity<String> singUp(@Valid @RequestBody User user) {
        userService.singUp(user);
         return new ResponseEntity<String>(HttpStatus.CREATED);

    }





}