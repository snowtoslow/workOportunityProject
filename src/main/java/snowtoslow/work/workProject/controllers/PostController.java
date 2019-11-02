package snowtoslow.work.workProject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snowtoslow.work.workProject.models.Post;
import snowtoslow.work.workProject.service.PostService;
import snowtoslow.work.workProject.service.PostServiceImpl;

import java.util.List;

@RestController
public class PostController implements PostService {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("/post")
    public List<Post> readAllPosts() {
        return postService.readAllPosts();
    }

    @GetMapping("/post/{postId}")
    public Post readPostById(@PathVariable int id) {
        return postService.readPostById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/post/update")
    public ResponseEntity<Object> updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping("/post/{postId}")
    public void deletePost(int id) {
        postService.deletePost(id);
    }
}
