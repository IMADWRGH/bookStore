package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Model.Book;
import com.bookStore.bookStore.Model.MyBookList;
import com.bookStore.bookStore.Service.BookService;
import com.bookStore.bookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BookController {
    private final BookService bookService;
    private final MyBookListService myBookListService;

    @Autowired
    public BookController(BookService bookService, MyBookListService myBookListService) {
        this.bookService = bookService;
        this.myBookListService = myBookListService;
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
    @RequestMapping(path= "/mylist/{id}")
    public String getMyList(@PathVariable("id")  int id){
       Book book= bookService.getBook(id);
        MyBookList myBookList=new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
            myBookListService.addbbok(myBookList);
        return "redirect:/myBook";
    }
    @GetMapping(path = "/myBook")
    public String myBook(Model model){
        List<MyBookList> list=myBookListService.getList();
        model.addAttribute("book",list);
        return "myBook";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/availableBook";
    }
    @RequestMapping(path = "/edit/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
         Book book=bookService.getBook(id);
         model.addAttribute("book",book);
        return "editBook";
    }


}
