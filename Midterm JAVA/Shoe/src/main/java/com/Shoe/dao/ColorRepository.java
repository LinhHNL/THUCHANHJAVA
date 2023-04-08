package com.Shoe.dao;

import com.Shoe.model.Color;
import com.Shoe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query("select c from Color  c where  c.ColorId = ?1")
    Color findByColorId(Long colorId);
}
