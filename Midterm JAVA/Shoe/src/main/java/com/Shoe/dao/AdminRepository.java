package com.Shoe.dao;

import com.Shoe.model.Admin;
import com.Shoe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findAdminrByEmailAndPassword(String email, String password);

    Admin findCustomerByEmail(String email);
    Admin findByAdminID(Long adminId);

}
