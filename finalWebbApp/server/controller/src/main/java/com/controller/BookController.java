package com.controller;

import com.model.Book;
import com.model.BookGenre;
import com.model.UserData;
import com.serviceAPI.IBookDTOService;
import com.serviceAPI.IBookService;
import com.serviceAPI.IUserDataDTOService;
import com.serviceAPI.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserDataDTOService userDataDTOService;

    @Autowired
    private IBookDTOService bookDTOService;

    private static Logger log = Logger.getLogger(UserController.class);

    public BookController() {

    }

    @RequestMapping(
            value = {"books"},
            method = {RequestMethod.GET}
    )

    @ResponseBody

    public List<Book> getAllBooks(HttpServletResponse response, HttpServletRequest request) {


        response.setContentType("application/json");
        List<Book> bookList = this.bookDTOService.getBookList(this.bookService.getAllBooks());
        if (bookList.isEmpty()) {
            response.setStatus(204);
            return new ArrayList<>();
        } else {
            return bookList;
        }
    }

    @RequestMapping(
            value = {"books-by-genre"},
            method = {RequestMethod.GET}
    )

    @ResponseBody

    public List<Book> getAllBooksByGenre(HttpServletResponse response, HttpServletRequest request) {
        String genreString = request.getHeader("genre");
        genreString.toUpperCase();
        BookGenre genre = BookGenre.valueOf(genreString);
        response.setContentType("application/json");
        List<Book> bookList = this.bookDTOService.getBookList(this.bookService.getAllBooksByGenre(genre));
        if (bookList.isEmpty()) {
            response.setStatus(204);
            return new ArrayList<>();
        } else {
            return bookList;
        }
    }

}