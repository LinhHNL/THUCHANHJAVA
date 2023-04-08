package com.Shoe.api;

import com.Shoe.dao.OrderRepository;
import com.Shoe.model.*;
import com.Shoe.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
@Autowired
  private   ProductService productService;
@Autowired
private  SizeService sizeService;
@Autowired
private   ColorService colorService;
@Autowired
private GenreService genreService;
@Autowired
private OrderService orderService;

    @RequestMapping("/delete-item")
    public String deleteitem(HttpServletRequest request, @RequestParam("id") int id){
        HttpSession session  = request.getSession();
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");
        cartItems.remove(cartItems.get(id-1));
        session.setAttribute("cart", cartItems);
        return "redirect:/cart/view";

    }
    @Autowired
    private BrandService brandService;
    @RequestMapping(value = "/complete",method = RequestMethod.POST)
    public String order_complete(Model model,HttpServletRequest request,@RequestParam("address") String address){
        HttpSession session = request.getSession();

        Customer customer = (Customer) session.getAttribute("customer");
            if(customer==null){
                return "redirect:/user";
            }
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cart");

            if (cartItemList==null){
                return "redirect:/index";
            }

        Double total = 0.0;
        if(cartItemList!=null) {
            for (CartItem cart : cartItemList
            ) {
                total += cart.getPrice();

            }
        }

        Order order = new Order();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datetime  = formatter.format(currentDateTime);
        order.setDate(LocalDateTime.parse(datetime, formatter));
        order.setCustomer(customer);
        order.setAddress(address);
        order.setTotalPrice(total);
        order.setStatus(1);
        Order orderresult = orderService.addOrder(order);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartItem cart:cartItemList
        ) {
            orderDetailList.add(orderService.addOrderDetail(new OrderDetail(orderresult,cart.getProduct(),cart.getColor(),cart.getSize(),cart.getQuantity(),cart.getPrice())));
        }

        List<Genre> genreList =genreService.getAll();
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        model.addAttribute("genreList", genreList);
        model.addAttribute("customer",customer);
        session.setAttribute("cart",null);

        return "order-complete";

    }
    @GetMapping("/check-out")
    public String check_out(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Genre> genreList =genreService.getAll();
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        model.addAttribute("genreList", genreList);
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer==null){
            return "redirect:/user";
        }

        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");

        if (cartItems==null){
            return "redirect:/index";
        }
        Double total = 1.0;
        if(cartItems!=null) {
            for (CartItem cart : cartItems
            ) {
                total += cart.getPrice();

            }
            model.addAttribute("total", total);
        }
        model.addAttribute("customer",customer);
        return "checkout";
    }


// ...

    @RequestMapping("/add-to-cart")
    public String addToCart(HttpServletRequest request, @RequestParam("product-id") Long productId,
                            @RequestParam("quantity") int quantity, @RequestParam(name = "color", required = false) String color,
                            @RequestParam(name ="size", required = false) String size ) {

        double price = productService.getProductByID(productId).getPrice() * quantity;
        List<Size> sizes = (List<Size>) productService.getProductByID(productId).getSizes();
        List<Color> colors = (List<Color>) productService.getProductByID(productId).getColors();

        // Lấy giá trị mặc định nếu thiếu tham số color
        Color c = colors.get(0);
        if (color != null && !color.isEmpty()) {
            Long colorid = Long.parseLong(color);
            c = colorService.getColorByID(colorid);
        }

        // Lấy size theo ID
        Size s;
        if (size != null && !size.isEmpty()) {
            s = sizes.get(0);
        } else {
            Long sizeid = Long.parseLong(size);
            s = sizeService.getSizeByID(sizeid);
        }

        HttpSession session = request.getSession();

        // Kiểm tra xem giỏ hàng đã được khởi tạo chưa, nếu chưa thì tạo mới
        if (session.getAttribute("cart") == null) {
            List<CartItem> cartItems = new ArrayList<>();
            CartItem item = new CartItem(1, productService.getProductByID(productId), price, quantity, c, s);
            cartItems.add(item);
            session.setAttribute("cart", cartItems);
        } else {
            List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");
            int length = cartItems.size();
            CartItem item = new CartItem(length + 1, productService.getProductByID(productId), price, quantity, c, s);
            cartItems.add(item);
            session.setAttribute("cart", cartItems);
        }

        return "redirect:/cart/view";
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {

        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");
        model.addAttribute("list_cart",cartItems);
        List<Genre> genreList =genreService.getAll();
        Double total =0.0;
        if (session.getAttribute("customer") != null) {
            Customer customer = (Customer) session.getAttribute("customer");
            model.addAttribute("customer",customer);
        }
        if(cartItems!=null) {
            for (CartItem cart : cartItems
            ) {
                total += cart.getPrice();

            }
            model.addAttribute("total", total);
        }
        List<Brand> brandList = brandService.getAll();

        model.addAttribute("brandList", brandList);
        model.addAttribute("genreList", genreList);
        return "cart";
    }

}
