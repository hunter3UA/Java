package com.example.hotelApp.services;

import com.example.hotelApp.dto.OrderElementDTO;
import com.example.hotelApp.mapper.AutoMapper;
import com.example.hotelApp.models.OrderElement;
import com.example.hotelApp.repository.OrderElementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderElementService implements IOrderElementsService{


    @Autowired
    private OrderElementsRepository orderElementsRepository;

    @Override
    public List<OrderElementDTO> getByOrderID(Integer orderID) {

        List<OrderElement> allElementsOfOrder=orderElementsRepository.allByOrderID(orderID);
        if(allElementsOfOrder!=null){
            return AutoMapper.mapListOfOrderElements(allElementsOfOrder);
        }
        return new ArrayList<OrderElementDTO>();
    }
}
