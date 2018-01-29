package com.github.matheusbritzke.service;

import com.github.matheusbritzke.exception.BookNotFoundException;
import com.github.matheusbritzke.model.Book;
import com.github.matheusbritzke.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book newBook){
        bookRepository.save(newBook);
        return newBook;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return findBook(bookId);
    }

    public Book updateBook(Long bookId, Book book) {
        Book oldBook = findBook(bookId);
        oldBook.setName(book.getName());
        oldBook.setGender(book.getGender());
        bookRepository.save(oldBook);
        return oldBook;
    }


    public Book deleteBook(Long bookId) {
        Book oldBook = findBook(bookId);
        bookRepository.delete(bookId);
        return oldBook;
    }

    private Book findBook(Long bookId){
        Book book = bookRepository.findOne(bookId);
        if(bookId == null || bookId < 0 || book == null)
            throw new BookNotFoundException();
        return book;
    }
}
