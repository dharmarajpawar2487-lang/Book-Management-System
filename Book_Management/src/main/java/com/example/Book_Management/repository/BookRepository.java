package com.example.Book_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.Book_Management.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    // ✅ Reset auto increment ID when delete happens
    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE BOOK ALTER COLUMN ID RESTART WITH 1", nativeQuery = true)
    void resetId();
}
