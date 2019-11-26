package snowtoslow.work.workProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import snowtoslow.work.workProject.models.Post;


import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PostController postController;



    /*@RequestMapping("/")
    public String viewHomePage(Model model){
        List<Post> posts = postController.readAllPosts();
        model.addAttribute("listOfPosts",posts);

        return "home";

    }
    */

    @ModelAttribute("messages")
    public List<Post> posts() {
        return postController.readAllPosts();
    }
}
