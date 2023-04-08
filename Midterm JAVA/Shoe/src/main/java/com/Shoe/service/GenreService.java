package com.Shoe.service;

import com.Shoe.dao.BrandRepository;
import com.Shoe.dao.GenreRepository;
import com.Shoe.model.Brand;
import com.Shoe.model.Genre;
import com.Shoe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
@Autowired
private  ProductService productService;
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
    public Genre getGenreByID(Long Id){
        return genreRepository.findById(Id).get();
    }
    public Genre add(Genre genre) {
      return   genreRepository.save(genre);
    }
    public Genre update(Genre genre){
        try{
            Genre g = genreRepository.findByGenreId(genre.getGenreId());
            if(g==null){
                return  null;
            }
            g.setName(genre.getName());

            return  genreRepository.save(g);
        }catch (DataAccessException e){
            throw new RuntimeException("Không thể cập nhật dữ liệu.", e);

        }
    }

    @Transactional
    public String delete(Long genreId) {
        try {
            Genre genre = genreRepository.findByGenreId(genreId);
            if(genre==null){
                return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";
            }
            for (Product product: genre.getListOfProducts()
            ) {
                productService.delete(product.getProductId());
            }
            genreRepository.deleteById(genreId);
            return "xóa thành công";
        } catch (EmptyResultDataAccessException e) {
            return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";

        } catch (DataAccessException e) {
            // Thông báo lỗi nếu
            return "có lỗi xảy ra trong quá trình xóa đối tượng";

        }

    }

}
