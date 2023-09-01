package com.skcet.day5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcet.day5.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{
    boolean existsById(int id);
    Optional<Book> findById(int id);
    void deleteById(Long eventId);
}
