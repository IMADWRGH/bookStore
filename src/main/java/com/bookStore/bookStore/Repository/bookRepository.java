package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book,Integer> {
}
