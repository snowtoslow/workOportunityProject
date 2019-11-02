package snowtoslow.work.workProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import snowtoslow.work.workProject.models.Comment;
import snowtoslow.work.workProject.repository.CommentRepository;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl {

    @Autowired
    public CommentRepository commentRepository;

    public List<Comment> readAllComments(){
        return commentRepository.findAll();
    }

    public Comment readCommentById(int id){
        Optional<Comment> comment = commentRepository.findById(id);

        if (!comment.isPresent()){
            System.out.println("There is not comment with such ID" + id);

        }
        return comment.get();
    }

    public ResponseEntity<Object> createComment(Comment comment){

        Comment savedComment = commentRepository.save(comment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{commentId}")
                .buildAndExpand(comment.getCommentId()).toUri();

        return ResponseEntity.created(location).build();

    }

    public ResponseEntity<Object> updateComment(Comment comment){

        Optional<Comment> commentOptional = commentRepository.findById(comment.getCommentId());

        if(!commentOptional.isPresent())
            return ResponseEntity.notFound().build();

        commentRepository.save(comment);
        return ResponseEntity.noContent().build();
    }

    public void deleteComment(int id){
        commentRepository.deleteById(id);
    }




}
