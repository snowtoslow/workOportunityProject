package snowtoslow.work.workProject.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import snowtoslow.work.workProject.models.Post;

import java.util.List;

@Service
public interface PostService {
    List<Post> readAllPosts();

    Post readPostById(int id);

    ResponseEntity<Object> createPost(Post post);

    ResponseEntity<Object> updatePost(Post post);

    void deletePost(int id);

}
