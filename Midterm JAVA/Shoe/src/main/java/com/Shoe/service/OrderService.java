package com.Shoe.service;

import com.Shoe.dao.OrderDetailRepository;
import com.Shoe.dao.OrderRepository;
import com.Shoe.model.Customer;
import com.Shoe.model.Order;
import com.Shoe.model.OrderDetail;
import com.Shoe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.jaxb.OrderAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    public List<Order> getAll(){
        return  orderRepository.findAll();
    }
    public Order addOrder(Order order){

        return orderRepository.save(order);


    }
    public Order getOrderByID(Long id){
        return  orderRepository.findByOrderId(id);
    }
    public Order changeStatus(int status,Long id){
        Order order = orderRepository.findById(id).get();
        if(order==null){
            return  null;
        }
        order.setStatus(status);
        orderRepository.save(order);
        return order;
    }
    public OrderDetail addOrderDetail(OrderDetail orderDetail){
        return  orderDetailRepository.save(orderDetail);
    }

    public List<Order> getAllByCustomer(Customer customer){
    return orderRepository.findAllByCustomer(customer);
    }

    public void deleteOrderDetailbyProduct(Product product){

        orderDetailRepository.deleteAllByProduct(product);
    }
    public String deleteOrder(Long id){
        try {
            Order order = orderRepository.findByOrderId(id);
            if(order==null){
                return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";
            }

                orderDetailRepository.deleteAllByOrder(order);
            orderRepository.delete(order);

            return "xóa thành công";
        } catch (EmptyResultDataAccessException e) {
            return "không tìm thấy đối tượng cần xóa trong cơ sở dữ liệu";

        } catch (DataAccessException e) {
            // Thông báo lỗi nếu
            return "có lỗi xảy ra trong quá trình xóa đối tượng";

        }

    }
    public Order update(Order ordertemp){
        Order order = orderRepository.findByOrderId(ordertemp.getOrderId());
        if(order==null)
            return null;
        order.setAddress(ordertemp.getAddress());
        order.setDate(ordertemp.getDate());
        order.setStatus(ordertemp.getStatus());
        order.setTotalPrice(ordertemp.getTotalPrice());
        return orderRepository.save(order);

    }
}
