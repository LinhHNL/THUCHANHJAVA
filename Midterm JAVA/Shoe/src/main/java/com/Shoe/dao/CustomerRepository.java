package com.Shoe.dao;

import com.Shoe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findCustomerByEmailAndPassword(String Email,String Password);
    Customer findCustomerByEmail(String Email);
    Customer findByCustomerId(Long CustomerId);

}
