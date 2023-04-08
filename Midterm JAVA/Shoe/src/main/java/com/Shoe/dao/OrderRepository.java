package com.Shoe.dao;

import com.Shoe.model.Customer;
import com.Shoe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByCustomer(Customer customer);
    @Query("select o from  Order  o where o.OrderId = ?1")
    Order findByOrderId(Long OrderId);

}
