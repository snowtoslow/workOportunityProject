package snowtoslow.work.workProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snowtoslow.work.workProject.models.Post;



public interface PostRepository extends JpaRepository<Post, Integer> {


}
