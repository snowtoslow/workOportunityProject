package snowtoslow.work.workProject.service;

import org.springframework.http.ResponseEntity;

import snowtoslow.work.workProject.models.User;


import java.util.List;

public interface UserService {

    List<User> readAllUsers();

    User readUserById(int id);

    ResponseEntity<Object> createUser(User user);

    ResponseEntity<Object> updateUser(User user);

    void deleteUser(int id);


}
