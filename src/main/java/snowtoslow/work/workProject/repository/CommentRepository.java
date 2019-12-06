package snowtoslow.work.workProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snowtoslow.work.workProject.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
