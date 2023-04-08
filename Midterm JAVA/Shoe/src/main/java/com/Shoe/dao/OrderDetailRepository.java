package com.Shoe.dao;

import com.Shoe.model.Customer;
import com.Shoe.model.Order;
import com.Shoe.model.OrderDetail;
import com.Shoe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findAllByProduct(Product product);
    void deleteAllByProduct(Product product);
    void deleteAllByOrder(Order order);
}
