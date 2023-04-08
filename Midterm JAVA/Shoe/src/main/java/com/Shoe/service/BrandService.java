package com.Shoe.service;

import com.Shoe.dao.BrandRepository;
import com.Shoe.dao.ProductRepository;
import com.Shoe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;
@Autowired
private ProductService productService;
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
    public Brand getBrandByID(Long Id){

        return brandRepository.findByBrandId(Id);
    }
    public Brand add(Brand brand) {
        return  brandRepository.save(brand);

    }
    public Brand update(Brand brand){
        try{
            Brand b = brandRepository.findByBrandId(brand.getBrandId());
            if(b==null){
                return  null;
            }
            b.setName(brand.getName());

            return brandRepository.save(b);
        }catch (DataAccessException  e){
            throw new RuntimeException("Không thể cập nhật dữ liệu.", e);

        }
    }
@Transactional
    public String delete(Long brandId) {
        try {
            Brand brand = brandRepository.findByBrandId(brandId);
            if(brand==null){
                return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";
            }
            for (Product product: brand.getListOfProducts()
                 ) {
                productService.delete(product.getProductId());
            }
            brandRepository.deleteById(brandId);
            return "xóa thành công";
        } catch (EmptyResultDataAccessException e) {
            return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";

        } catch (DataAccessException e) {
            // Thông báo lỗi nếu
            return "có lỗi xảy ra trong quá trình xóa đối tượng";

        }

    }


}
