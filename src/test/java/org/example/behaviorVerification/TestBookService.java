package org.example.behaviorVerification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class TestBookService {
    BookRepository bookRepository;

    BookService bookService;
    @BeforeEach
    public void start(){
        bookRepository= Mockito.mock(BookRepository.class);
        bookService=new BookService(bookRepository);
    }


    //this is called as a behavior test
    @Test
    public void testSaveBook(){
        Book book1=new Book("101","Kalyani",1000, LocalDate.now());
        bookService.saveBook(book1);
        Mockito.verify(bookRepository,Mockito.times(1)).save(book1);
        Mockito.verifyNoMoreInteractions(bookRepository);
        Mockito.verify(bookRepository,Mockito.atLeastOnce()).save(book1);
        Mockito.verify(bookRepository,Mockito.atMost(1)).save(book1);
    }


}
