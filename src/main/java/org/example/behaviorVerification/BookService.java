package org.example.behaviorVerification;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void saveBook(Book book){

        if (book.getPrice()<500){
            return;
        }
        else if (book.getTitle().isEmpty()){
            return;
        }
        bookRepository.save(book);
    }
}
