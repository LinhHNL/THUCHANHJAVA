package tdtu.edu.Lab7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab7Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);

	}

	@Bean
	public CommandLineRunner demo(){
		return (args) -> {
			System.out.println("Huỳnh Nhật Linh - 52100815");
		};
	}

}
