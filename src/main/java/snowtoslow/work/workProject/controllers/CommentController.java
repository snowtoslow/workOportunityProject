package snowtoslow.work.workProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snowtoslow.work.workProject.models.Comment;
import snowtoslow.work.workProject.service.CommentService;
import snowtoslow.work.workProject.service.CommentServiceImpl;


import java.util.List;        //DfSFfFASFASF
@RestController
public class CommentController implements CommentService {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/comments")
    public List<Comment> readAllComments() {
        return commentService.readAllComments();
    }

    @GetMapping("/comments/{commentId}")
    public Comment readCommentById(@PathVariable int id) {
        return commentService.readCommentById(id);
    }

    @PostMapping("/comments")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment) {
        return null;
    }

    @PutMapping("/comments/update")
    public ResponseEntity<Object> updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }

    @DeleteMapping("comments/{commentId}")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
    }
}
