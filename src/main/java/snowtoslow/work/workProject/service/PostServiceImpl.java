package snowtoslow.work.workProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import snowtoslow.work.workProject.models.Post;
import snowtoslow.work.workProject.repository.PostRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl {

    @Autowired
    private PostRepository postRepository;

    public List<Post> readAllPosts(){
        return postRepository.findAll();
    }

    public Post readPostById(int id){
        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent()){
            System.out.println("There is not post with such ID" + id);

        }
        return post.get();
    }

    public ResponseEntity<Object> createPost(Post post){
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}")
                .buildAndExpand(post.getPostId()).toUri();

        return ResponseEntity.created(location).build();

    }

    public ResponseEntity<Object> updatePost(Post post){

        Optional<Post> postOptional = postRepository.findById(post.getPostId());

        if(!postOptional.isPresent())
            return ResponseEntity.notFound().build();

        postRepository.save(post);
        return ResponseEntity.noContent().build();
    }

    public void deletePost(int id){
        postRepository.deleteById(id);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }




}
