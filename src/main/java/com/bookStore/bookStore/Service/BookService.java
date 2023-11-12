package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;

import com.bookStore.bookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<Book> addBook(Book book){
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.CREATED);
    }


    public List<Book> getBooks(){
       return bookRepository.findAll();
    }
}
