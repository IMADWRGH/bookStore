package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyBookListController {
    private final MyBookListService myBookListService;
    @Autowired
    public MyBookListController(MyBookListService myBookListService) {
        this.myBookListService = myBookListService;
    }
}
