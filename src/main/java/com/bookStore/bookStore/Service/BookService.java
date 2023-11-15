package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Book;

import com.bookStore.bookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }


    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }

    public Book getBook(int id){
        return bookRepository.findById(id).get();
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
}
