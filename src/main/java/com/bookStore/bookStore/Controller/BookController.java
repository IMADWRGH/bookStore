package com.bookStore.bookStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {
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
}
