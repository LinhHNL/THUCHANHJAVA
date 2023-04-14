package com.example.lab8_ex2;

import com.example.lab8_ex2.Repository.EmployeeRep;
import com.example.lab8_ex2.Service.IEmployService;
import com.example.lab8_ex2.Service.Implement.EmployeeImp;
import jakarta.persistence.Embeddable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab8Ex2Application implements CommandLineRunner {
    @Autowired
    private EmployeeRep employeeRep;

    @Autowired

    private IEmployService service = new EmployeeImp();
    public static void main(String[] args) {
        SpringApplication.run(Lab8Ex2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.getAll().forEach(p-> System.out.println(p.toString()));

    }
}
