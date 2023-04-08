package com.Shoe.api;

import com.Shoe.model.Brand;
import com.Shoe.model.Customer;
import com.Shoe.model.Genre;
import com.Shoe.model.Product;

import com.Shoe.service.BrandService;
import com.Shoe.service.GenreService;
import com.Shoe.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.*;

@Controller
@RequestMapping()
public class HomePageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private BrandService brandService;



    @GetMapping()


    public  String getAll(HttpServletRequest request,Model model){
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        List<Product> list =  productService.getAll();
        model.addAttribute("listproduct",list);
        List<Genre> genreList =genreService.getAll();
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            Customer customer = (Customer) session.getAttribute("customer");
            model.addAttribute("customer",customer);
        }
        model.addAttribute("genreList", genreList);
        return "index";

    }
    @GetMapping("index")

    public  String getAll1(HttpServletRequest request, Model model){
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        List<Product> list =  productService.getAll();
        model.addAttribute("listproduct",list);
        List<Genre> genreList =genreService.getAll();
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            Customer customer = (Customer) session.getAttribute("customer");
            model.addAttribute("customer",customer);
        }
        model.addAttribute("genreList", genreList);
        return "index";

    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)

    public String ProductDetail(Model model,@RequestParam("productid") String id,HttpServletRequest request){
       Product product =  productService.getProductByID(Long.valueOf(id));
        List<Genre> genreList =genreService.getAll();
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            Customer customer = (Customer) session.getAttribute("customer");
            model.addAttribute("customer",customer);
        }

        model.addAttribute("genreList", genreList);
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        model.addAttribute("product",product);
        return "product-detail";
    }
    @GetMapping(value = "/search")
    public String search(Model model,@RequestParam("content") String content,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            Customer customer = (Customer) session.getAttribute("customer");
            model.addAttribute("customer",customer);
        }
        productService.searchProduct(content);
        List<Genre> genreList =genreService.getAll();
        model.addAttribute("genreList", genreList);
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        List<Product> list =  productService.searchProduct(content);
        model.addAttribute("listproduct",list);
        return "search";
    }
    @RequestMapping(value = "/genre",method = RequestMethod.GET)
    public String Category(Model model,@RequestParam("genre") Long genre,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            Customer customer = (Customer) session.getAttribute("customer");
            model.addAttribute("customer",customer);
        }
        System.out.println(genre);
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        Genre genres = genreService.getGenreByID(genre);
        Set<Product> list = genres.getListOfProducts();
        model.addAttribute("listproduct",list);
        List<Genre> genreList =genreService.getAll();
        model.addAttribute("genreList", genreList);

        return "search";
    }
    @RequestMapping(value = "/brand",method = RequestMethod.GET)
    public String Brand(Model model,@RequestParam("brand") Long brand,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            Customer customer = (Customer) session.getAttribute("customer");
            model.addAttribute("customer",customer);
        }
        System.out.println(brand);
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        List<Genre> genreList =genreService.getAll();
        model.addAttribute("genreList", genreList);
        Brand brands = brandService.getBrandByID(brand);

        Set<Product> list = brands.getListOfProducts();
        model.addAttribute("listproduct",list);


        return "search";
    }


}
