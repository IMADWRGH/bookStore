package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    ////////// router navigate//////////////
    @GetMapping(path = "/")
    public String home(){
        return "index";
    }

    @GetMapping(path = "/bookRegister")
    public String BookRegister(){
        return "bookRegister";
    }

    @GetMapping(path = "/myBook")
    public String myBook(){
        return "myBook";
    }




    ///////////// Logic {///////////////
    @PostMapping(path= "/save")
    public String addBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/availableBook";
    }
    @GetMapping(path = "/availableBook")
    public ModelAndView availableBook(){
        List<Book> list =bookService.getAllBooks();
        return  new ModelAndView("availableBook","book",list);
    }
    @RequestMapping(path= "/myList/{id}")
    public String getMyList(@PathVariable  int id){
       Book book= bookService.getBook(id);

        return "redirect:/myBook";
    }


}
