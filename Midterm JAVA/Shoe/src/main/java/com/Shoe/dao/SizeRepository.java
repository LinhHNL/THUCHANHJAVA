package com.Shoe.dao;

import com.Shoe.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size,Long> {
    @Query("select s from Size s where s.SizeId = ?1")
    Size findBySizeId(Long sizeId);
}
