package com.crishna.bookStore.service;

import com.crishna.bookStore.models.Book;
import com.crishna.bookStore.models.Orders;
import com.crishna.bookStore.models.Purchase;
import com.crishna.bookStore.models.User;
import com.crishna.bookStore.models.customPojo.OrdersRequest;
import com.crishna.bookStore.repo.BookRepo;
import com.crishna.bookStore.repo.OrdersRepo;
import com.crishna.bookStore.repo.UserRepo;
import com.crishna.bookStore.service.base.BaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService extends BaseServiceImp<Orders, Integer> {

    OrdersRepo ordersRepo;

    protected OrdersService(JpaRepository<Orders, Integer> repo) {
        super(repo);
        ordersRepo = (OrdersRepo) repo;
    }

    @Autowired
    UserRepo userRepo;
    @Autowired
    BookRepo bookRepo;

    public Orders placeOrder(OrdersRequest ordersRequest) {

        Orders orders = new Orders();
        int userId = ordersRequest.getUserId();

        User user = userRepo.findById(userId).orElse(null);
        List<Purchase> purchaseList = new ArrayList<>();
        float totalPrice = 0.0f;
        for (OrdersRequest.OrderedItems item : ordersRequest.getOrderedItemsList()){
            Book book = bookRepo.findById(item.getBookId()).orElse(null);
            int quantity = item.getQuantity();
            float discount = book.getDiscount();
            float price = book.getPrice();
            float sellingPrice = (price * (100 - discount) / 100);

            totalPrice += sellingPrice * quantity;
            Purchase purchase = new Purchase(quantity,sellingPrice, orders, book);


            purchaseList.add(purchase);
        }


        orders.setUser(user);
        orders.setPurchases(purchaseList);
        orders.setTotal_price(totalPrice);

        orders = ordersRepo.save(orders);

        return orders;
    }
}
