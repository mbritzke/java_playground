package com.github.matheusbritzke.persistence;

import com.github.matheusbritzke.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book, Long>{
}
