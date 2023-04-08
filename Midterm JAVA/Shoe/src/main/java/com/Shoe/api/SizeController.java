package com.Shoe.api;

import com.Shoe.model.Size;


import com.Shoe.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/Size")
public class SizeController {
    @Autowired
    private SizeService sizeService;
    @GetMapping("/getAll")
    public List<Size> getSizeAll(){
        return sizeService.getAll();
    }
    @GetMapping("/getSize/{id}")
    public Size getSizeByID(@PathVariable("id") Long id){
        return  sizeService.getSizeByID(id);
    }
    @PostMapping("/updateSize")
    public Size update(@RequestParam Map<String,String > paramas){
        Size Size = new Size();
        Size.setName(paramas.get("name"));
        Size.setSizeId(Long.valueOf(paramas.get("id")));
        return sizeService.update(Size);
    }
    @RequestMapping(value = "/deleteSize/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
        return sizeService.delete(id);
    }
    @PostMapping("/addSize")
    public Size addSize(@RequestParam("name") String name){
       Size size = new Size();
       size.setName(name);
        return sizeService.addSize(size);
    }

}
