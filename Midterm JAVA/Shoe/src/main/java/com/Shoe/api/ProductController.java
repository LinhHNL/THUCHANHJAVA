package com.Shoe.api;

import com.Shoe.model.Product;
import com.Shoe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("admin")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product/addProduct")
    public Product addProduct(Model model, @RequestParam Map<String, String> params) {
        String name = params.get("name");
        Double price = Double.parseDouble(params.get("price"));
        String description = params.get("description");
        String url = params.get("urlimage");

        String[] colorIds = params.get("colors[]").split(",");
        String[] sizeIds = params.get("sizes[]").split(",");
        Set<Long> colorIdsl = new HashSet<>();
        for (String color:colorIds
        ) {
            colorIdsl.add(Long.parseLong(color));
        }
        Set<Long> sizes = new HashSet<>();

        for (String size:sizeIds
        ) {
            sizes.add(Long.parseLong(size));

        }
        Long genreId = Long.parseLong(params.get("genre"));
        Long brandId = Long.parseLong(params.get("brand"));
        Product product = productService.add(name,price,description,url,genreId,brandId,colorIdsl,sizes);
        return product;
    }
    @PostMapping("/product/updateProduct")
    public Product updateProduct(@RequestParam Map<String, String> params) {
        String name = params.get("name");
        Double price = Double.parseDouble(params.get("price"));
        String description = params.get("description");
        String url = params.get("urlimage");
        Long id = Long.parseLong(params.get("id"));

        String[] colorIds = params.get("colors[]").split(",");
        String[] sizeIds = params.get("sizes[]").split(",");
        Set<Long> colorIdsl = new HashSet<>();
        for (String color:colorIds
        ) {
            colorIdsl.add(Long.parseLong(color));
        }
        Set<Long> sizes = new HashSet<>();

        for (String size:sizeIds
        ) {
            sizes.add(Long.parseLong(size));

        }
        Long genreId = Long.parseLong(params.get("genre"));
        Long brandId = Long.parseLong(params.get("brand"));
        Product product = productService.update(id,name,price,description,url,genreId,brandId,colorIdsl,sizes);
        return product;
    }
    @RequestMapping(value = "/product/deleteProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {

       return    ResponseEntity.ok(productService.delete(id));
    }
    @GetMapping("/product/getAll")
    public List<Product> getAllProduct(){
        return productService.getAll();
    }
    @GetMapping("/product/getProductByID/{id}")
    public Product getProductByID(@PathVariable("id") Long id){
        return productService.getProductByID(id);
    }
        @PostMapping("/product/addColor")
    public Product addColor(@RequestParam Map<String, String> params){
        Long productid = Long.valueOf(params.get("id"));
        String[] colorIds = params.get("colors[]").split(",");
        Set<Long> colorIdsl = new HashSet<>();
        for (String color:colorIds
        ) {
            colorIdsl.add(Long.parseLong(color));
        }
        return productService.addColor(colorIdsl,productid);
    }
    @PostMapping("/product/addsize")
    public Product addSize(@RequestParam Map<String, String> params){
        Long productid = Long.valueOf(params.get("id"));
        String[] sizeid = params.get("sizes[]").split(",");
        Set<Long> sizeids = new HashSet<>();
        for (String size:sizeid
        ) {
            sizeids.add(Long.parseLong(size));
        }
        return productService.addSize(sizeids,productid);
    }

}
