package messagesApiRest.Controller;

import messagesApiRest.Domain.User;
import messagesApiRest.Service.UserServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/listUser")
    public List<User> listUsers() {
        return userService.listUsers();
    }



    @PostMapping("/singUp")
    public ResponseEntity<String> singUp(@Valid @RequestBody User user) {
        userService.singUp(user);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteUserById")
    public ResponseEntity<String> deleteUser(@Valid @RequestBody Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

}