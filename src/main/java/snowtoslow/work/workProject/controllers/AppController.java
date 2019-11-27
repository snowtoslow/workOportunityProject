package snowtoslow.work.workProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import snowtoslow.work.workProject.models.Post;
import snowtoslow.work.workProject.models.User;


import java.net.URI;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PostController postController;

    @Autowired
    private UserController userController;





    @RequestMapping("/")
    public String viewHomePage(){
        return "home";

    }

    @RequestMapping("/posts")
    public String ListProducts(Model model){
        List<Post> posts = postController.readAllPosts();
        model.addAttribute("posts",posts);

        return "posts";

    }

    @RequestMapping("/users")
    public String ListOfUsers(Model model){
        List<User> users = userController.readAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);

        return "new_post";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("post") Post post) {
        postController.createPost(post);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPostPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_post");
        Post post = postController.readPostById(id);
        mav.addObject("post", post);

        return mav;
    }

}
