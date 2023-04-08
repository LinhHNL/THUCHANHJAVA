package com.Shoe.api;

import com.Shoe.model.Brand;
import com.Shoe.model.Customer;
import com.Shoe.model.Genre;
import com.Shoe.model.Order;
import com.Shoe.service.BrandService;
import com.Shoe.service.CustomerService;
import com.Shoe.service.GenreService;
import com.Shoe.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("user")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private  BrandService brandService;
    @Autowired
    private GenreService genreService;
    @GetMapping()
    public String view_login(Model model){
        return "login_signup";
    }
    @PostMapping(value = {"/login"})
    public String login(HttpServletRequest request, Model model, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password){
            Customer customer = customerService.check_login(email,password);
        HttpSession session = request.getSession();
            if(customer!=null){
                session.setAttribute("customer", customer);

                return "redirect:/index";
            }else {
                model.addAttribute("failedlogin",true);

                return "login_signup";
            }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/index";
    }

    @PostMapping("/signup")
    public String addCustomer(HttpServletRequest request,Model model,@RequestParam Map<String, String> params){
        Customer customer = customerService.addCustomer(params.get("name"),params.get("email"),params.get("address"),params.get("password"),params.get("phone"));
        HttpSession session = request.getSession();
        if(customer!=null){
            session.setAttribute("customer", customer);

            return "redirect:/index";
        }else {
            model.addAttribute("failedsingup",true);

            return "login_signup";
        }
    }
    @GetMapping("/view-order")
    public String view_order(Model model,HttpServletRequest request){


        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");
        if(customer==null){
            return "redirect:/user";
        }

        List<Order> list = orderService.getAllByCustomer(customer);
        HashMap<Integer,String> status = new HashMap<Integer, String>();
        status.put(1,"Đặt hàng thành công");
        status.put(2,"Đang giao hàng");
        status.put(3,"Đã Hủy");
        status.put(4,"Giao Hàng hàng thành công");
        model.addAttribute("listorder",list);
        model.addAttribute("status",status);
        List<Brand> brandList = brandService.getAll();


            model.addAttribute("customer",customer);

        model.addAttribute("brandList", brandList);
        List<Genre> genreList =genreService.getAll();
        model.addAttribute("genreList", genreList);
        return "view-order";
    }
    @GetMapping("/view-order-detail/{order_id}")
    public String viewOrderDetail(Model model,@PathVariable("order_id") Long id,HttpServletRequest request){
        List<Brand> brandList = brandService.getAll();
        HttpSession session = request.getSession();


        Customer customer = (Customer) session.getAttribute("customer");
        if(customer==null){
            return "redirect:/user";
        }
        if (session.getAttribute("customer") != null) {

            model.addAttribute("customer",customer);
        }
        model.addAttribute("brandList", brandList);
        List<Genre> genreList =genreService.getAll();
        model.addAttribute("genreList", genreList);
        model.addAttribute("list_order",orderService.getOrderByID(id));
        return "view-order-detail";
    }
}
