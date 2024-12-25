package org.example.exceptionHandling;

import java.sql.SQLException;
import java.util.List;

public class BookService {


    private BookRepository bookRepository;

    BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void addBook(Book book){
        if (book.getPrice()<500){
            return;
        }
        else if(book.getTitle().isEmpty()){
            return;
        }
        try {
            bookRepository.saveBook(book);
        } catch (SQLException e) {
            //log the statement
            throw new DataBaseWriteException("unable to perform write operation due to - "+e.getMessage());
        }
    }

  public int findTotalSum() throws DatabaseReadException {
        int total=0;
      List<Book> allBooks = null;
      try {
          allBooks = bookRepository.findAllBooks();
      } catch (SQLException e) {
          throw new DatabaseReadException("the read operation cannot be performed due to - "+e.getMessage());
      }
      for (Book book:
           allBooks) {

          total=total+book.getPrice();
      }
      return total;
  }
}
