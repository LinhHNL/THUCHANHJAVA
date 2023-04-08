package com.Shoe.service;

import com.Shoe.dao.ColorRepository;
import com.Shoe.model.Color;
import com.Shoe.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ColorService {
    @Autowired
    private ColorRepository colorRepository;

    public List<Color> getAll() {
        return colorRepository.findAll();
    }
    public Color getColorByID(Long Id){
        return colorRepository.findByColorId(Id);
    }
    public void add(Color color) {
        colorRepository.save(color);
    }
    public Color update(Color color){
        try{
            Color c = colorRepository.findByColorId(color.getColorId());
            if(c==null){
                return  null;
            }
            c.setName(color.getName());

            return  colorRepository.save(c);
        }catch (DataAccessException e){
            throw new RuntimeException("Không thể cập nhật dữ liệu.", e);

        }
    }

    public String delete(Long colorid) {
        try {
            Color color = colorRepository.findByColorId(colorid);
            if(color==null){
                return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";
            }
            colorRepository.delete(color);
            return "xóa thành công";
        } catch (EmptyResultDataAccessException e) {
            return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";

        } catch (DataAccessException e) {
            // Thông báo lỗi nếu
            return "có lỗi xảy ra trong quá trình xóa đối tượng";

        }

    }
    public Color addColor(Color color){
      return   colorRepository.save(color);
    }
}
