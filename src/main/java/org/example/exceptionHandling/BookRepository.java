package org.example.exceptionHandling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {

    public void saveBook(Book book) throws SQLException;
    public List<Book> findAllBooks() throws SQLException;


}
