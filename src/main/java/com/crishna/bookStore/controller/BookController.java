package com.crishna.bookStore.controller;

import com.crishna.bookStore.controller.base.BaseControllerImp;
import com.crishna.bookStore.models.Book;
import com.crishna.bookStore.service.BookService;
import com.crishna.bookStore.service.base.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController extends BaseControllerImp<Book, Integer> {

    BookService bookService;

    public BookController(BaseService<Book, Integer> baseService) {
        super(baseService);
        this.bookService = (BookService) baseService;
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<List<Book>> getByName(@PathVariable String name){
        return ResponseEntity.ok(bookService.getByName(name));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getByAuthor(@PathVariable String author){
        return ResponseEntity.ok(bookService.getByAutherName(author));
    }

    @PutMapping(value = "/price", params = {"price", "id"})
    public ResponseEntity<Book> updatePriceById(@RequestParam float price, @RequestParam int id){
        return ResponseEntity.ok(bookService.updatePriceById(id, price));
    }

    @PutMapping(value = "/discount", params = {"discount", "id"})
    public ResponseEntity<Book> updateDiscountById(@RequestParam float discount, @RequestParam int id){
        return ResponseEntity.ok(bookService.updateDiscountById(id, discount));
    }




}
