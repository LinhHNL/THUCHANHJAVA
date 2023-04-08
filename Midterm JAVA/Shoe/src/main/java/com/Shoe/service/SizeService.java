package com.Shoe.service;

import com.Shoe.dao.ColorRepository;
import com.Shoe.dao.SizeRepository;
import com.Shoe.model.Color;
import com.Shoe.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getAll() {
        return sizeRepository.findAll();
    }
    public Size getSizeByID(Long Id){
        return sizeRepository.findBySizeId(Id);
    }
    public void add(Size Size) {
        sizeRepository.save(Size);
    }
    public Size update(Size size){
        try{
            Size c = sizeRepository.findBySizeId(size.getSizeId());
            if(c==null){
                return  null;
            }
            c.setName(size.getName());

            return sizeRepository.save(c);
        }catch (DataAccessException e){
            throw new RuntimeException("Không thể cập nhật dữ liệu.", e);

        }
    }
    @Transactional
    public String delete(Long sizeid) {
        try {
            Size size = sizeRepository.findBySizeId(sizeid);
            if(size==null){
                return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";
            }
            sizeRepository.delete(size);
            return "xóa thành công";
        } catch (EmptyResultDataAccessException e) {
            return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";

        } catch (DataAccessException e) {
            // Thông báo lỗi nếu
            return "có lỗi xảy ra trong quá trình xóa đối tượng";

        }

    }
    public Size addSize(Size size){
        return sizeRepository.save(size);
    }


}
