package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBookListService {
    private final MyBookRepository myBookRepository;
    @Autowired
    public MyBookListService(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }
}
