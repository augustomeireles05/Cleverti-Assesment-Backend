package pt.com.assesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pt.com.assesment"})
public class ClevertiAssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClevertiAssesmentApplication.class, args);
	}

}
