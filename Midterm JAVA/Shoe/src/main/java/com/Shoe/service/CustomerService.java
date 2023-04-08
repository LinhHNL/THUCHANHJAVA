package com.Shoe.service;

import com.Shoe.dao.CustomerRepository;
import com.Shoe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer check_login(String Email, String Password){
        return customerRepository.findCustomerByEmailAndPassword(Email,Password);
    }
    public Customer addCustomer(String Name,String email,String address,String password,String phone){
        Customer customer = customerRepository.findCustomerByEmail(email);
        if(customer!=null){
            return  null;

        }
        Customer customer1 = new Customer();
        customer1.setEmail(email);
        customer1.setAddress(address);
        customer1.setName(Name);
        customer1.setPassword(password);
        customer1.setPhone(phone);
        return  customerRepository.save(customer1);
    }
    public Customer update(Long id,String Name,String email,String address,String password,String phone){
        Customer customer = customerRepository.findByCustomerId(id);
        if(customer!=null){
            return  null;

        }
        Customer customer1 = new Customer();
        customer1.setEmail(email);
        customer1.setAddress(address);
        customer1.setName(Name);
        customer1.setPassword(password);
        customer1.setPhone(phone);
        return  customerRepository.save(customer1);
    }
}
