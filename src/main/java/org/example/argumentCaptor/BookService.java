package org.example.argumentCaptor;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void addBooks(Book book){
        bookRepository.saveBook(book);
    }

    public int findTotalSum(){
        int total=0;
        List<Book> allBooks = bookRepository.findAllBooks();
        for (Book book:
             allBooks) {
            total=total+book.getPrice();
        }
        return total;
    }
}
