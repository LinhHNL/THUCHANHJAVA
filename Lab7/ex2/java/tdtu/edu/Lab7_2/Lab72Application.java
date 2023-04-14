package tdtu.edu.Lab7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;
import tdtu.edu.Lab7_2.Service.StudentServices;
import tdtu.edu.Lab7_2.model.Student;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab72Application extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab72Application.class, args);
	}

	@Autowired
	private StudentServices studentServices;

	@Override
	public void run(String...args) throws Exception {
		Student student1 = new Student(1L, "HuynhNhatLinh1", 19, "HuynhNhatLinh1@gmail");
		studentServices.createStudent(student1);
		Student student2 = new Student(2L, "HuynhNhatLinh2", 19, "HuynhNhatLinh2@gmail");
		studentServices.createStudent(student2);

		Student student3 = new Student(3L, "HuynhNhatLinh3", 20, "HuynhNhatLinh3@gmail");
		studentServices.createStudent(student3);
		System.out.println("Add 3 Students");
		studentServices.getAllStudents().forEach(System.out::println);


		Optional<Student> updateStudent = studentServices.getStudentById(1L);
		if(updateStudent.isPresent()){
			Student student = updateStudent.get();
			student.setName("New HuynhNhatLinh's name");
			studentServices.createStudent(student);
		}
		System.out.println("Update");
		studentServices.getAllStudents().forEach(System.out::println);

		System.out.println("Delete");
		studentServices.deleteStudentById(3L);
		studentServices.getAllStudents().forEach(System.out::println);




	}




}

