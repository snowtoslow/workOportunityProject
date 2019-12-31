package snowtoslow.work.workProject.uicontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import snowtoslow.work.workProject.controllers.PostController;
import snowtoslow.work.workProject.models.Post;

import java.util.List;


@Controller
public class PostUiController {

    @Autowired
    private PostController postController;

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



    @RequestMapping("/new")
    public String showNewPostPage(Model model) {
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

    @RequestMapping("/delete/{id}")
    public String deletePost(@PathVariable(name = "id") int id) {
        postController.deletePost(id);
        return "redirect:/";
    }

    @RequestMapping("/postinfo/{id}")
    public String fullPostInfo(@PathVariable(name = "id") int id,Model model){
        postController.readPostById(id);

        Post post = postController.readPostById(id);

        model.addAttribute("postinfo",post);

        return "post_full_info";
    }

    @RequestMapping("/postcontent/{id}")
    public String postContent(@PathVariable(name = "id") int id,Model model){
        Post post = postController.readPostById(id);

        model.addAttribute("postcontent",post);

        return "post_content";

    }


}
