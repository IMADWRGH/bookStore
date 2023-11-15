package com.bookStore.bookStore.Controller;


import com.bookStore.bookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyBookListController {
    private final MyBookListService myBookListService;
    @Autowired
    public MyBookListController(MyBookListService myBookListService) {
        this.myBookListService = myBookListService;
    }
    @RequestMapping(path = "/deleteMy/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        myBookListService.deleteBook(id);
        return "redirect:/myBook";
    }

}
