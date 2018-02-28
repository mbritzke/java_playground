package com.github.matheusbritzke.controller;

import com.github.matheusbritzke.model.Book;
import com.github.matheusbritzke.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    public Book addNewBook(@RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable(value = "bookId") Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.PUT)
    public Book updateBook(@PathVariable(value = "bookId") Integer bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public Book deleteCar(@PathVariable(value = "bookId") Integer bookId) {
        return bookService.deleteBook(bookId);
    }
}