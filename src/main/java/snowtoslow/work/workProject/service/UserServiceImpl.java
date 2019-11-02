package snowtoslow.work.workProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import snowtoslow.work.workProject.models.User;
import snowtoslow.work.workProject.repository.UserRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    public UserRepository userRepository;

    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    public User readUserById(int id){
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()){
            System.out.println("There is not user with such ID" + id);

        }
        return user.get();
    }

    public ResponseEntity<Object> createUser(User user){
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
                .buildAndExpand(user.getUserId()).toUri();

        return ResponseEntity.created(location).build();

    }

    public ResponseEntity<Object> updateUser(User user){

        Optional<User> postOptional = userRepository.findById(user.getUserId());

        if(!postOptional.isPresent())
            return ResponseEntity.notFound().build();

        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

}
