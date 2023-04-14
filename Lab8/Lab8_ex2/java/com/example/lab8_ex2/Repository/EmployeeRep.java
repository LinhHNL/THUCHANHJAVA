package com.example.lab8_ex2.Repository;

import com.example.lab8_ex2.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRep extends JpaRepository<Employee,Integer> {

}
