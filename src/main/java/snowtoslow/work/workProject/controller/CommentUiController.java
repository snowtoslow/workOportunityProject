package snowtoslow.work.workProject.uicontrollers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import snowtoslow.work.workProject.controllers.CommentController;
import snowtoslow.work.workProject.exceptions.NotFountPostException;
import snowtoslow.work.workProject.models.Comment;
import snowtoslow.work.workProject.repository.PostRepository;
import snowtoslow.work.workProject.service.CommentService;
import snowtoslow.work.workProject.transfer.CommentDTO;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CommentUiController {


    private final CommentService commentService;
    private final PostRepository postRepository;


    public String ListOfComments(Model model) {
        List<Comment> comments = commentService.readAllComments();
        model.addAttribute("comments", comments);

        return null;
    }

    @GetMapping("/createcomment/{id}")
    public String showNewCommentPage(Model model, @PathVariable("id") int id) {
        postRepository.findById(id)
                .map(post -> {
                            log.info("Post with id = '{}' faunded.", id);
                            Comment comment = new Comment();
                            comment.setPost(post);
                            model.addAttribute("comment", comment);
                            return "new_comment";
                        }
                ).orElseThrow(() -> new NotFountPostException(String.format("Post with id = '%d' faunded.", id)));

        return "new_comment";
    }


    @PostMapping("/savecomment")
    public String saveComment(@ModelAttribute("comment") CommentDTO comment) {

        log.info();

        commentService.createComment(comment);

        return "redirect:/";
    }
}
