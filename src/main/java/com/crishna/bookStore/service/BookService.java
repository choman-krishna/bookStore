package com.crishna.bookStore.service;

import com.crishna.bookStore.models.Book;
import com.crishna.bookStore.repo.BookRepo;
import com.crishna.bookStore.service.base.BaseServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO :
 * Notes --> @Transactional, findById & getReferenceById -> (Lazy Loader)
 *
 * */

@Service
public class BookService extends BaseServiceImp<Book, Integer> {

    BookRepo bookRepo;

    protected BookService(JpaRepository<Book, Integer> repo) {
        super(repo);
        this.bookRepo = (BookRepo) repo;
    }

    public List<Book> getByName(String name){
        return bookRepo.getByName(name);
    }

    public List<Book> getByAutherName(String name){
        return bookRepo.getByAutherName(name);
    }

    @Transactional
    public Book updatePriceById(int id, float price) {
        bookRepo.updatePriceById(id, price);
        return bookRepo.findById(id).orElse(null);
    }

    public Book updateDiscountById(int id, float discount) {
        bookRepo.updateDiscountById(id, discount);
        return bookRepo.findById(id).orElse(null);
    }

    public float getSellingPriceById(int id){
        Book book = bookRepo.findById(id).orElse(null);
        float discount = book.getDiscount();
        float price = book.getPrice();

        return (price * (100 - discount) / 100);
    }
}
