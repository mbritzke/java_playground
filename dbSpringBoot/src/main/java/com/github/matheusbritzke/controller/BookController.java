package com.github.matheusbritzke.controller;

import com.github.matheusbritzke.model.Book;
import com.github.matheusbritzke.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method=RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST)
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long id) {
        Book foundBook = bookRepository.findOne(id);
        if(foundBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(foundBook);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Book bookActual) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        book.setName(bookActual.getName());
        book.setGender(bookActual.getGender());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }
        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }
}
