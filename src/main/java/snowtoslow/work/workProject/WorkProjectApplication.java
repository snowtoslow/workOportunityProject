package snowtoslow.work.workProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import snowtoslow.work.workProject.Classes.CommentClass;
import snowtoslow.work.workProject.Helper.Helpers;

@SpringBootApplication
public class WorkProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkProjectApplication.class, args);
		CommentClass commentClass = new CommentClass();
		commentClass.setCreateTime(Helpers.timeHelper());
		System.out.println("Time:"+ commentClass.getCreateTime());


	}
}
