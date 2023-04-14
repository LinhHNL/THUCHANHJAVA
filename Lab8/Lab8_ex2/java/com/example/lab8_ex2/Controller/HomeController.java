package com.example.lab8_ex2.Controller;

import com.example.lab8_ex2.Model.Employee;
import com.example.lab8_ex2.Repository.EmployeeRep;
import com.example.lab8_ex2.Service.IEmployService;
import com.example.lab8_ex2.Service.Implement.EmployeeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class HomeController {
    @Autowired
    private  IEmployService service;

    @GetMapping("")
    public String homePage(Model model){
        model.addAttribute("employees",service.getAll());
        return "index";
    }


}
