package com.crishna.bookStore.repo;

import com.crishna.bookStore.models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.name) = :name")
    List<Book> getByName(String name);

    @Query("SELECT b FROM Book b WHERE LOWER(b.author) = :authorName")
    List<Book> getByAutherName(String authorName);


    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.price = :price WHERE b.id = :id")
    void updatePriceById(@Param("id") int id, @Param("price") float price);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.discount = :discount WHERE b.id = :id")
    void updateDiscountById(int id, float discount);
}
