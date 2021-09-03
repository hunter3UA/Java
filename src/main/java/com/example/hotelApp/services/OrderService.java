package com.example.hotelApp.services;


import com.example.hotelApp.constants.OrderConstants;
import com.example.hotelApp.dto.OrderDTO;
import com.example.hotelApp.dto.UpdateOrderDTO;
import com.example.hotelApp.mapper.AutoMapper;
import com.example.hotelApp.models.*;
import com.example.hotelApp.repository.*;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{


    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private OrderElementsRepository orderElementsRepository;


    @Override
    public OrderDTO createOrder(Integer user_id) {


          if(userRepository.existsById(user_id) && userRepository.findById(user_id).get().getIs_deleted()==false){
              User userToOrder=userRepository.findById(user_id).get();
              ShoppingCart cartByUserID=cartRepository.byUserID(user_id);
              ArrayList<ShoppingCartItem> allItems=cartItemRepository.allByCartID(cartByUserID.getId());
              if(!userToOrder.getIs_deleted() && allItems!=null){
                  Order newOrder=new Order(0,userToOrder,false,LocalDate.now(),orderStatusRepository.findById(OrderConstants.ORDER_STATUS_PREPARING).get(),0.00);
                  newOrder=orderRepository.save(newOrder);
                  Double order_sum=0.00;
                  for(int i=0;i<allItems.size();i++){
                      order_sum+=allItems.get(i).getItem_price()*allItems.get(i).getQuantity();
                      OrderElement newOrderElement=new OrderElement(0,newOrder,allItems.get(i).getProduct().getProduct_name());
                      orderElementsRepository.save(newOrderElement);
                  }
                  newOrder.setOrder_sum(order_sum);
                  newOrder= orderRepository.save(newOrder);
                  return AutoMapper.mapOrder(newOrder);

              }
          }

        return new OrderDTO();
    }

    @Override
    public List<OrderDTO> allByUser(Integer user_id) {
        List<Order> orders=orderRepository.allByUserID(user_id);
        return AutoMapper.mapListOfOrders(orders);
    }

    @Override
    public OrderDTO updateOrder(UpdateOrderDTO updateOrderDTO) {
        if(orderRepository.existsById(updateOrderDTO.getId())){
            Order orderToUpdate=orderRepository.findById(updateOrderDTO.getId()).get();
            orderToUpdate.setIs_payed(orderToUpdate.getIs_payed());
            orderToUpdate.setOrderStatus(orderStatusRepository.findById(updateOrderDTO.getOrderStatus()).get());
            orderToUpdate =  orderRepository.save(orderToUpdate);
            return AutoMapper.mapOrder(orderToUpdate);
        }
        return new OrderDTO();
    }
}
