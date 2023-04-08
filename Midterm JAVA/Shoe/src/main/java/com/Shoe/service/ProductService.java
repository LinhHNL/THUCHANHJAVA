package com.Shoe.service;


import com.Shoe.dao.*;
import com.Shoe.model.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
private ColorRepository  colorRepository ;
    @Autowired

    private BrandRepository  brandRepository ;
    @Autowired
private SizeRepository   sizeRepository ;
    @Autowired
private GenreRepository  genreRepository ;
    @Autowired
    private  OrderService orderService;
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product update(Long id,String name, Double price, String Description,String url, Long GenreId, Long BrandId, Set<Long> colorid,Set<Long> sizeids ) {
       try{
           Product product = productRepository.findProductByProductId(id);
           if(product==null){
               return  null;
           }
           product.getColors().removeAll(product.getColors());
           product.getSizes().removeAll(product.getSizes());
           product.setPrice(price);
           product.setName(name);
           product.setDescription(Description);
           product.setURLImage(url);
           System.out.println(BrandId);
           System.out.println(GenreId);
           Brand brand = brandRepository.findById(BrandId).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
           Genre genre = genreRepository.findById(GenreId).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
           product.setBrand(brand);
           product.setGenre(genre);
           Set<Color> colors = new HashSet<>();
           for (Long colorId : colorid) {
               Color color = colorRepository.findById(colorId).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
               colors.add(color);
           }
           Set<Size> sizes = new HashSet<>();
           for (Long sizeid : sizeids) {
               Size size = sizeRepository.findById(sizeid).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
               sizes.add(size);
           }

           product.setColors(colors);
           product.setSizes(sizes);
           productRepository.save(product);
           return product;
       }catch (DataAccessException  e){
           throw new RuntimeException("Không thể cập nhật dữ liệu.", e);

       }

    }
    public Product add(String name, Double price, String Description,String url, Long GenreId, Long BrandId, Set<Long> colorid,Set<Long> sizeids ) {

        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        product.setDescription(Description);
        product.setURLImage(url);
        System.out.println(BrandId);
        System.out.println(GenreId);
       Brand brand = brandRepository.findById(BrandId).orElseThrow(() -> new IllegalArgumentException("Invalid brand id"));
       Genre genre = genreRepository.findById(GenreId).orElseThrow(() -> new IllegalArgumentException("Invalid genre id"));
        product.setBrand(brand);
        product.setGenre(genre);
        Set<Color> colors = new HashSet<>();
        for (Long colorId : colorid) {
            Color color = colorRepository.findById(colorId).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
            colors.add(color);
        }
        Set<Size> sizes = new HashSet<>();
        for (Long sizeid : sizeids) {
            Size size = sizeRepository.findById(sizeid).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
            sizes.add(size);
        }

        product.setColors(colors);
        product.setSizes(sizes);
        productRepository.save(product);
        return product;
    }
    @Transactional
    public String delete(Long productId) {

            try {
                Product product = productRepository.findProductByProductId(productId);
                if(product==null){
                    return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";
                }
                product.getColors().removeAll(product.getColors());
                product.getSizes().removeAll(product.getSizes());
                orderService.deleteOrderDetailbyProduct(product);
                productRepository.deleteById(productId);
                return "xóa thành công";
            } catch (EmptyResultDataAccessException e) {
                return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";

            } catch (DataAccessException e) {
                // Thông báo lỗi nếu
                return "có lỗi xảy ra trong quá trình xóa đối tượng";

            }




    }


    public Product addColor(Set<Long> colorid,Long productId) {
        try {
            Product product = productRepository.findProductByProductId(productId);
            if (product == null) {
                return null;
            }
            Set<Color> colors = new HashSet<>();
            for (Long colorId : colorid) {
                Color color = colorRepository.findById(colorId).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
                colors.add(color);
            }

            colors.addAll(product.getColors());
            product.setColors(colors);
            return product;
        } catch (DataAccessException e) {
            // Thông báo lỗi nếu
            throw new RuntimeException("Không thể cập nhật dữ liệu.", e);


        }
    }
    public Product addSize(Set<Long> sizesid,Long productId) {
        try {
            Product product = productRepository.findProductByProductId(productId);
            if (product == null) {
                return null;
            }
            Set<Size> sizes = new HashSet<>();
            for (Long sizeid : sizesid) {
                Size size = sizeRepository.findById(sizeid).orElseThrow(() -> new IllegalArgumentException("Invalid color id"));
                sizes.add(size);
            }

            sizes.addAll(product.getSizes());
            product.setSizes(sizes);
            return product;
        } catch (DataAccessException e) {
            // Thông báo lỗi nếu
            throw new RuntimeException("Không thể cập nhật dữ liệu.", e);


        }
    }
    public Product getProductByID(Long ProductId){
      return   productRepository.findById(ProductId).get();
    }
    public  List<Product> searchProduct(String content){
        return productRepository.search(content);

    }

}
