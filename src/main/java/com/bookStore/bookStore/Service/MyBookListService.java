package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.MyBookList;
import com.bookStore.bookStore.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    private final MyBookRepository myBookRepository;
    @Autowired
    public MyBookListService(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }
    public void addbbok(MyBookList myBookList){
        myBookRepository.save(myBookList);
    }
    public List<MyBookList> getList(){
       return myBookRepository.findAll();

    }

    public void deleteBook(int id) {
        myBookRepository.deleteById(id);
    }
}
