package com.github.matheusbritzke.repository;

import com.github.matheusbritzke.exception.BookNotFoundException;
import com.github.matheusbritzke.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Book> rowMapper;

    public BookDAO(){
        this.rowMapper = new BeanPropertyRowMapper<>(Book.class);
    }

    public Book insertBook(Book newBook){
        String sql = "INSERT INTO books (name, gender) values (?, ?)";
        jdbcTemplate.update(sql, newBook.getName(), newBook.getGender());
        return newBook;
    }

    public List<Book> getAllBooks(){
        String sql = "SELECT bookId as id, name, gender FROM books";
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Book getBookById(Integer bookId) throws BookNotFoundException{
        return findBookById(bookId);
    }

    private Book findBookById(Integer bookId){
        try {
            String sql = "SELECT bookId as id, name, gender FROM books WHERE bookId=?";
            return jdbcTemplate.queryForObject(sql, rowMapper, bookId);
        } catch (EmptyResultDataAccessException e){
            throw new BookNotFoundException();
        }
    }

    public Book updateBook(Integer bookId, Book book){
        String sql = "UPDATE books SET name=?, gender=? WHERE bookId=?";
        jdbcTemplate.update(sql, book.getName(), book.getGender(), bookId);
        return book;
    }

    public Book deleteBook(Integer bookId){
        Book book = findBookById(bookId);
        String sql = "DELETE FROM books WHERE bookId=?";
        jdbcTemplate.update(sql, bookId);
        return book;
    }
}
