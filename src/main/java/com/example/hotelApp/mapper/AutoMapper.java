package com.example.hotelApp.mapper;

import com.example.hotelApp.dto.*;
import com.example.hotelApp.models.*;

import java.util.*;

public class AutoMapper {
    public static UserDTO mapUser(User user){
        UserDTO newUserDTO=new UserDTO(user.getId(),user.getName(), user.getEmail());
        return newUserDTO;
    }
    public static List<UserDTO> mapListOfUsers(List<User> users){
        List<UserDTO> allUsers= new ArrayList<>();

        for(int i=0;i<users.size();i++){

            UserDTO newUserDTO=mapUser(users.get(i));
            allUsers.add(newUserDTO);
        }
        return allUsers;
    }

    public static ProductDTO mapProduct(Product product){
        ProductDTO newProductDTO=new ProductDTO(product.getId(),product.getUnit(),product.getProductSubCategory(),product.getManufacturer(),
                product.getProduct_name(),product.getProduct_price(),product.getDescription());
        return newProductDTO;
    }
    public static List<ProductDTO> mapListOfProducts(List<Product> products){
        List<ProductDTO> productsBySubCategoryID=new ArrayList<>();
        for (int i=0;i<products.size();i++){
            ProductDTO newProductDTO=mapProduct(products.get(i));
            productsBySubCategoryID.add(newProductDTO);
        }
        return productsBySubCategoryID;
    }

    public static CartItemDTO mapCartItem(ShoppingCartItem shoppingCartItem){
        CartItemDTO cartItemDTO=new CartItemDTO(shoppingCartItem.getId(),shoppingCartItem.getProduct(),shoppingCartItem.getQuantity(),shoppingCartItem.getCart().getId(),shoppingCartItem.getItem_price());
        return cartItemDTO;
    }
    public static List<CartItemDTO> mapListOfItems(List<ShoppingCartItem> items){
        List<CartItemDTO> allItemsDTO=new ArrayList<>();
        for(int i=0;i<items.size();i++){
            CartItemDTO newCartItemDTO=mapCartItem(items.get(i));
            allItemsDTO.add(newCartItemDTO);
        }
        return allItemsDTO;

    }

    public static CartDTO mapCart(ShoppingCart shoppingCart){
        CartDTO newCartDTO=new CartDTO(shoppingCart.getId(),shoppingCart.getUser().getId(),shoppingCart.getRegistered_at());
        return newCartDTO;
    }
    public static List<CartDTO> mapListOfCarts(List<ShoppingCart> carts){
        List<CartDTO> allCartsDTO=new ArrayList<>();
        for(int i=0;i<carts.size();i++){
            CartDTO newCartDTO=mapCart(carts.get(i));
            allCartsDTO.add(newCartDTO);
        }
        return allCartsDTO;

    }

    public static OrderDTO mapOrder(Order order){
        OrderDTO newOrderDTO= new OrderDTO(order.getId(),order.getUser().getId(),order.getDate_of_order(),order.getOrderStatus(),order.getIs_payed(),order.getOrder_sum());
        return newOrderDTO;

    }
    public static List<OrderDTO> mapListOfOrders(List<Order> orders){
        List<OrderDTO> allOrdersDTO=new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            OrderDTO newOrderDTO=mapOrder(orders.get(i));
            allOrdersDTO.add(newOrderDTO);
        }
        return allOrdersDTO;
    }

    public static OrderElementDTO mapOrderElement(OrderElement orderElement){
        OrderElementDTO orderElementDTO=new OrderElementDTO(orderElement.getId(),orderElement.getOrder().getId(),orderElement.getProduct_name());
        return orderElementDTO;
    }
    public static List<OrderElementDTO> mapListOfOrderElements(List<OrderElement> orderElements){
        List<OrderElementDTO> allElementsByOrder=new ArrayList<>();
        for(int i=0;i<orderElements.size();i++){
            OrderElementDTO newOrderElementDTO=mapOrderElement(orderElements.get(i));
            allElementsByOrder.add(newOrderElementDTO);
        }
        return allElementsByOrder;
    }



}
