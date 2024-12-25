package org.example.argumentCaptor;

import java.util.List;

public interface BookRepository {

    public void saveBook(Book book);

    public List<Book> findAllBooks();


}
