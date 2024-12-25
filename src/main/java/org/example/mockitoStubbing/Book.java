package org.example.mockitoStubbing;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private String bookId;
    private String title;
    private int price;
    private LocalDate localDate;

    public Book() {
    }

    public Book(String bookId, String title, int price, LocalDate localDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.localDate = localDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && Objects.equals(title, book.title) && Objects.equals(localDate, book.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, localDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                '}';
    }
}
