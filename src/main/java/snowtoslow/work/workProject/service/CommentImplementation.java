package snowtoslow.work.workProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import snowtoslow.work.workProject.models.Comment;
import snowtoslow.work.workProject.repository.CommentReposiroty;


import java.net.URI;
import java.util.List;
import java.util.Optional;

public class CommentImplementation {

    @Autowired
    public CommentReposiroty commentReposiroty;

    List<Comment> readAllComments(){
        return commentReposiroty.findAll();
    }

    public Comment readCommentById(int id){
        Optional<Comment> comment = commentReposiroty.findById(id);

        if (!comment.isPresent()){
            System.out.println("There is not comment with such ID" + id);

        }
        return comment.get();
    }

    public ResponseEntity<Object> createComment(Comment comment){

        Comment savedComment = commentReposiroty.save(comment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{commentId}")
                .buildAndExpand(comment.getCommentId()).toUri();

        return ResponseEntity.created(location).build();

    }

    public ResponseEntity<Object> updateComment(Comment comment){

        Optional<Comment> commentOptional = commentReposiroty.findById(comment.getCommentId());

        if(!commentOptional.isPresent())
            return ResponseEntity.notFound().build();

        commentReposiroty.save(comment);
        return ResponseEntity.noContent().build();
    }

    public void deleteComment(int id){
        commentReposiroty.deleteById(id);
    }




}
