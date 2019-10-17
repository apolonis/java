package mikroservices.dbservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "mikroservices.dbservices.Repository")
@SpringBootApplication
public class DbServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServicesApplication.class, args);
	}

}
