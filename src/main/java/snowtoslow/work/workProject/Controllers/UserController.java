package snowtoslow.work.workProject.Controllers;

import org.springframework.web.bind.annotation.*;
import snowtoslow.work.workProject.Helper.Helpers;
import snowtoslow.work.workProject.Properties.UserClass;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("user")
@RestController
public class UserController{

    private Map<String, UserClass> mymap = new HashMap<>();
    private UserClass userClass = new UserClass();
    @PostMapping
    private String getUserID(@RequestBody UserClass userClass){
        userClass.setUserId(Helpers.idHelper());

        mymap.put(userClass.getUserId(),userClass);

        return userClass.getUserId();
    }

    @GetMapping("{userId}")
    private UserClass getInfoById(@PathVariable String userId ){

        return mymap.get(userId);
    }

    public String getUserName(){
        userClass.setUserName("vova");
        return userClass.getUserName();
    }
    public String getPassword() {
        userClass.setUserPassword("12345");
        return userClass.getUserPassword();
    }
}
