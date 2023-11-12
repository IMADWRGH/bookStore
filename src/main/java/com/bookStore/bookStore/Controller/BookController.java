package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(path = "/availableBook")
    public String availableBook(){
        return "availableBook";
    }


    ///////////// Logic {///////////////
    @PostMapping(path= "/save")
    public String addBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/availableBook";
    }
    @GetMapping(path = "/availableBook")
    public ModelAndView avaiableBook(){
        List<Book> list= bookService.getBooks();
return null;
    }


}
