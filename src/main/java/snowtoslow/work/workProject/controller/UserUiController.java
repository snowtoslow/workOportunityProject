package snowtoslow.work.workProject.uicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import snowtoslow.work.workProject.controllers.UserController;
import snowtoslow.work.workProject.models.User;

import java.util.List;

@Controller
public class UserUiController {

    @Autowired
    private UserController userController;

    @RequestMapping("/users")
    public String ListOfUsers(Model model){
        List<User> users = userController.readAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @RequestMapping("/newuser")
    public String showNewUserPage(Model model){
        User user = new User();
        model.addAttribute("user",user);

        return "new_user";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userController.createUser(user);

        return "redirect:/";
    }

    @RequestMapping("edituser/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userController.readUserById(id);
        mav.addObject("user",user);

        return mav;

    }

    @RequestMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable(name = "id") int id){

        userController.deleteUser(id);

        return "redirect:/";
    }

    @RequestMapping("userinfo/{id}")
    public String fullUserInfo(@PathVariable(name = "id") int id, Model model){
        User user = userController.readUserById(id);

        model.addAttribute("userinfo",user);

        return "user_full_info";
    }

}
