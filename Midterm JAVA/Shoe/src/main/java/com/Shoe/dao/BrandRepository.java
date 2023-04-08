package com.Shoe.dao;

import com.Shoe.model.Brand;
import com.Shoe.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository  extends JpaRepository<Brand, Long> {
    @Query("Select b from Brand b where b.BrandId = ?1")
    Brand findByBrandId(Long brandId);
}
