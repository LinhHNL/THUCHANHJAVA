package com.Shoe.api;

import com.Shoe.model.Admin;

import com.Shoe.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping(value = {"/","/view"})
    public String view(){
        return "login_admin";
    }
    @PostMapping(value = {"/login"})
    public ResponseEntity<String> login(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password, HttpServletRequest request){
       HttpSession session = request.getSession();

       Admin admin = adminService.check_login(email,password);
       if(admin==null){
           return ResponseEntity.ok("Đăng nhập thất bạn vui lòng thử lại");
       }
        session.setAttribute("admin",admin) ;

       return ResponseEntity.ok("Đăng nhập thành công");
    }



}
