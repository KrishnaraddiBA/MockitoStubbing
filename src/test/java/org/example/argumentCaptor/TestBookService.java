package org.example.argumentCaptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBookService {

    BookRepository bookRepository;
    BookService bookService;
    @BeforeEach
    public void init(){
        bookRepository= Mockito.mock(BookRepository.class);
        bookService=new BookService(bookRepository);
    }

    @Test
    public void TesttotalSum(){

        Book book1=new Book("101","Mahabharath",1000, LocalDate.now());
        ArgumentCaptor<Book> argumentCaptor=ArgumentCaptor.forClass(Book.class);
        int totalSum = bookService.findTotalSum();
        Mockito.verify(bookRepository).findAllBooks();
    }

    @Test
    public void testSaveMethod(){
        Book book1=new Book("101","Mahabharath",1000,LocalDate.now());
        ArgumentCaptor<Book> argumentCaptor=ArgumentCaptor.forClass(Book.class);
        bookService.addBooks(book1);
        Mockito.verify(bookRepository).saveBook(argumentCaptor.capture());
        Book value = argumentCaptor.getValue();
        assertEquals("Mahabharath",value.getTitle());
    }
}
