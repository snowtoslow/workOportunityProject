package snowtoslow.work.workProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snowtoslow.work.workProject.models.User;
import snowtoslow.work.workProject.service.UserService;
import snowtoslow.work.workProject.service.UserServiceImpl;

import java.util.List;

@RestController
public class UserController implements UserService {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user")
    public List<User> readAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User readUserById(@PathVariable int id) {
        return userService.readUserById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/update")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
