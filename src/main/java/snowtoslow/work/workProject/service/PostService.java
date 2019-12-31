package snowtoslow.work.workProject.service;


import org.springframework.http.ResponseEntity;
import snowtoslow.work.workProject.models.Post;

import java.util.List;


public interface PostService {
    List<Post> readAllPosts();

    Post readPostById(int id);

    ResponseEntity<Object> createPost(Post post);

    ResponseEntity<Object> updatePost(Post post);

    void deletePost(int id);

    void savePost(Post post);



}
