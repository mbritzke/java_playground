package com.github.matheusbritzke.controller;

import com.github.matheusbritzke.model.Book;
import com.github.matheusbritzke.persistence.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDAO bookDAO;

    @RequestMapping(method = RequestMethod.POST)
    public Book add(@Valid @RequestBody Book newBook){
        return BookDAO.save(newBook);
    }
}
