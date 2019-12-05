package snowtoslow.work.workProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import snowtoslow.work.workProject.models.Comment;
import snowtoslow.work.workProject.models.Post;
import snowtoslow.work.workProject.models.User;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PostController postController;

    @Autowired
    private UserController userController;

    @Autowired
    private CommentController commentController;





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

    /*@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("post") Post post) {
        postController.createPost(post);//save post

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPostPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_post");
        Post post = postController.readPostById(id);
        mav.addObject("post",post);


        return mav;

    }*/

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

    //users
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

    //comments
    public String ListOfComments(Model model){
        List<Comment> comments = commentController.readAllComments();
        model.addAttribute("comments", comments);

        return null;
    }

    @RequestMapping("/newcomment")
    public String showNewCommentPage(Model model){
        Comment comment = new Comment();
        model.addAttribute("comment",comment);

        return "new_comment";
    }

    @RequestMapping(value = "/savecomment", method = RequestMethod.POST)
    public String saveComment(@ModelAttribute("comment") Comment comment) {
        commentController.createComment(comment);

        return "redirect:/";
    }








}
