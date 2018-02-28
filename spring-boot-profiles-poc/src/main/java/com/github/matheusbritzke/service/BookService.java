package com.github.matheusbritzke.service;

import com.github.matheusbritzke.model.Book;
import com.github.matheusbritzke.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public Book addBook(Book newBook){
        return bookDAO.insertBook(newBook);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public Book getBookById(Integer bookId) {
        return bookDAO.getBookById(bookId);
    }

    public Book updateBook(Integer bookId, Book book) {
        return bookDAO.updateBook(bookId, book);
    }

    public Book deleteBook(Integer bookId) {
        return bookDAO.deleteBook(bookId);
    }

}
