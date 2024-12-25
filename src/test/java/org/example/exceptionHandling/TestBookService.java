package org.example.exceptionHandling;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestBookService {


    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    public void initialize(){
    bookRepository= Mockito.mock(BookRepository.class);
    bookService=new BookService(bookRepository);
    }

    @Test
    public void testFindAllBooks() throws SQLException {
        Mockito.when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        assertThrows(DatabaseReadException.class,()->bookService.findTotalSum());

    }

    @Test
    public void testSaveMethodByThrowingWxception() throws SQLException {

        Book book1=new Book("101","Mahabharath",1000,LocalDate.now());
        Mockito.doThrow(SQLException.class).when(bookRepository).saveBook(book1);
        assertThrows(DataBaseWriteException.class,()->bookService.addBook(book1));
    }


}
