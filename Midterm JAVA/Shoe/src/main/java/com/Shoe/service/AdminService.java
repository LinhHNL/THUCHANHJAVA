package com.Shoe.service;


import com.Shoe.dao.AdminRepository;
import com.Shoe.model.Admin;
import com.Shoe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public Admin check_login(String Email, String Password){
        return adminRepository.findAdminrByEmailAndPassword(Email,Password);
    }
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }
    public Admin getAdminByID(Long Id){
        return adminRepository.getReferenceById(Id);
    }

    public void delete(Long adminId) {

            adminRepository.deleteById(adminId);

    }

    public Admin addAdmin(String name, String email, String password, int level) {
        Admin admin = adminRepository.findCustomerByEmail(email);
        if(admin!=null){
            return  null;
        }
      return   adminRepository.save(new Admin(name, email,  password, level));
    }


}
