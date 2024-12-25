package org.example.mockitoStubbing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBookService {
    BookRepository bookRepository;
    BookService bookService;
    @BeforeEach
    public void runFirst(){
         bookRepository=Mockito.mock(BookRepository.class);
         bookService=new BookService(bookRepository);
    }
    @Test
    public void testFindDiscountPrice(){
        //arrange
        List<Book> li=new ArrayList<>();
        li.add(new Book("101","Mahabharath",1000, LocalDate.now()));
        li.add(new Book("102","Ramayan",1000, LocalDate.now()));
        li.add(new Book("103","Kalki",1500, LocalDate.now()));
        //act
        Mockito.when(bookRepository.findAllBooks(7)).thenReturn(li);
        //assert
        assertEquals(3,bookService.findDiscountPrice(10,7).size());
    }

    @Test
    public void testfindtotalSum(){
        Book book1=new Book("101","Mahabharath",1000, LocalDate.now());
        Book book2 = new Book("102", "Ramayan", 1000, LocalDate.now());
        Book book3 = new Book("103", "Kalki", 1500, LocalDate.now());

        List<Book> li=new ArrayList<>();
        li.add(book1);
        li.add(book2);
        li.add(book3);

        Mockito.when(bookRepository.totalBookIds(7)).thenReturn(li);

        //assert
        assertEquals(3500,bookService.findTotalSum(7));
    }

    @Test
    public void testSaveMethod(){
        Book book1=new Book("101","Kalki",2000,LocalDate.now());
        Mockito.doNothing().when(bookRepository).save(book1);
        bookService.saveBook(book1);
    }
    //here it compares an equals method
    @Test
    public void testSaveMethodByusingAnatherBookRef(){
        Book book1=new Book(null,"Mahabharath",1000,LocalDate.now());
        BookDto bookDto=new BookDto("Mahabharath",1000,LocalDate.now());
        Mockito.doNothing().when(bookRepository).save(book1);
        bookService.saveBook(bookDto);
    }
}
