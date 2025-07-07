package com.crishna.bookStore.controller;

import com.crishna.bookStore.controller.base.BaseControllerImp;
import com.crishna.bookStore.models.Orders;
import com.crishna.bookStore.models.customPojo.OrdersRequest;
import com.crishna.bookStore.service.OrdersService;
import com.crishna.bookStore.service.base.BaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseControllerImp<Orders, Integer> {

    OrdersService ordersService;

    public OrdersController(BaseService<Orders, Integer> baseService) {
        super(baseService);
        ordersService = (OrdersService) baseService;
    }

    @PostMapping("/place")
    public Orders placeOrders(@RequestBody OrdersRequest ordersRequest){
        System.out.println(ordersRequest);
        return ordersService.placeOrder(ordersRequest);
    }

}
