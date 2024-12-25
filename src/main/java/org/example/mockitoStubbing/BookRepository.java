package org.example.mockitoStubbing;

import java.util.List;

public interface BookRepository {

    public void save(Book book);
    public List<Book> findAllBooks(int noOfDays);

    public List<Book> totalBookIds(int days);


}
