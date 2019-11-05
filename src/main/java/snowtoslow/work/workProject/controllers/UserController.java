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

    @GetMapping("/users")
    public List<User> readAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User readUserById(@PathVariable int id) {
        return userService.readUserById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/update")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
