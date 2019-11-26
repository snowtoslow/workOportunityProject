package snowtoslow.work.workProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import snowtoslow.work.workProject.controllers.AppController;

@SpringBootApplication
public class WorkProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkProjectApplication.class, args);

	}
}
