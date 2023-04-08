package com.Shoe.dao;


import com.Shoe.model.Brand;
import com.Shoe.model.Customer;
import com.Shoe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p , Brand b, Genre g,Color c,Size s WHERE p.Name LIKE %?1%"
            + " OR b.Name LIKE %?1%"
            + " OR c.Name LIKE %?1%"
            + " OR s.Name LIKE %?1%"
            + " OR g.Name LIKE %?1%"
            )
     List<Product> search(String keyword);
    @Query("SELECT p from Product p  where p.ProductId = ?1")
     Product findProductByProductId(Long ProductId);

}
