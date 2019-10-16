package snowtoslow.work.workProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import snowtoslow.work.workProject.Controllers.UserController;
import snowtoslow.work.workProject.Properties.CommentClass;
import snowtoslow.work.workProject.Helper.Helpers;
import snowtoslow.work.workProject.Properties.UserClass;

@SpringBootApplication
public class WorkProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkProjectApplication.class, args);
		CommentClass commentClass = new CommentClass();
		commentClass.setCreateTime(Helpers.timeHelper());
		System.out.println("Time:"+ commentClass.getCreateTime());






	}
}
