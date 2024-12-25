package org.example.mockitoStubbing;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }
    public void saveBook(BookDto bookDto){
        Book book=new Book();
        book.setPrice(bookDto.getPrice());
        book.setTitle(bookDto.getTitle());
        book.setLocalDate(bookDto.getLocalDate());
        bookRepository.save(book);
    }

    public List<Book> findDiscountPrice(int discount,int noOfDays){
        List<Book> allBooks = bookRepository.findAllBooks(noOfDays);
        for (Book book:
             allBooks) {
            int price=book.getPrice();
            int totalPrice=price-(discount*price/100);
            book.setPrice(totalPrice);
        }
        return allBooks;
    }

    public int findTotalSum(int days){
        int totalPrice=0;

        List<Book> books = bookRepository.totalBookIds(days);
        for(Book book:books){
            totalPrice=totalPrice+book.getPrice();
        }
        return totalPrice;
    }

}
