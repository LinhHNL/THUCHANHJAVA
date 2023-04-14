package com.example.lab8_ex2.Service;

import com.example.lab8_ex2.Model.Employee;
import com.example.lab8_ex2.Service.Implement.EmployeeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEmployService {
    public static IEmployService getInstance() {
        return new EmployeeImp();
    }
    List<Employee> getAll();

    Employee getOne(int id);

    void delete(int id);

    void add(Employee employee);

    void update(Employee employee);
}
