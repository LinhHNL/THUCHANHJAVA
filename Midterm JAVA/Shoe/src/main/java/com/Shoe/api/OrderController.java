package com.Shoe.api;

import com.Shoe.model.Order;
import com.Shoe.service.OrderService;
import jdk.dynalink.NamedOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/getAll")
    public List<Order> getAllOrder(){
        return orderService.getAll();
    }
    @GetMapping("/getDetailOrder/{id}")
    public Order getOrderByID(@PathVariable("id") Long id){
        return orderService.getOrderByID(id);
    }
    @PostMapping("/changeStatus")
    public  Order ChagneStatusOrder(@RequestParam Map<String,String> paramas){
      return   orderService.changeStatus(Integer.parseInt(paramas.get("status")), Long.valueOf(paramas.get("id")));

    }
    @RequestMapping(value = "/deleteOrder/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
        return orderService.deleteOrder(id);
    }
    @PostMapping("/updateOrder")

    public Order updateOrder(@RequestParam Map<String,String> params){
        Order order = new Order();
        order.setOrderId(Long.valueOf(params.get("id")));
        order.setAddress(params.get("address"));
        order.setStatus(Integer.parseInt(params.get("status")));
        DateTimeFormatter DATE_FORMAT =
                new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd HH:mm:ss").toFormatter();
        LocalDateTime ldt = LocalDateTime.parse(params.get("date"), DATE_FORMAT);
        order.setDate(ldt);
        order.setTotalPrice(Double.valueOf(params.get("totalprice")));
        return orderService.update(order);
    }


}
