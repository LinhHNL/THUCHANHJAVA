package com.Shoe.api;

import com.Shoe.model.Brand;
import com.Shoe.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
@GetMapping("/getAll")
    public List<Brand> getBrandAll(){
    return brandService.getAll();
}
    @GetMapping("/getBrand/{id}")
    public Brand getBrandByID(@PathVariable("id") Long id){
    return  brandService.getBrandByID(id);
    }
    @PostMapping("/addbrand")
    public Brand add(@RequestParam Map<String,String > paramas){
        Brand brand = new Brand();
        brand.setName(paramas.get("name"));

        return brandService.add(brand);
    }


    @PostMapping("/updateBrand")
    public Brand update(@RequestParam Map<String,String > paramas){
        Brand brand = new Brand();
        brand.setName(paramas.get("name"));
        brand.setBrandId(Long.valueOf(paramas.get("id")));
        return brandService.update(brand);
    }
    @RequestMapping(value = "/deleteBrand/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
    return brandService.delete(id);
    }

}
