package snowtoslow.work.workProject.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import snowtoslow.work.workProject.models.Comment;
import snowtoslow.work.workProject.models.Post;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> readAllComments();

    Comment readCommentById(int id);

    ResponseEntity<Object> createComment(Comment comment);

    ResponseEntity<Object> updateComment(Comment comment);

    void deleteComment(int id);


}
