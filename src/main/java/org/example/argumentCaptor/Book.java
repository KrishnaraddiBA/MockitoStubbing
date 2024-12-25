package org.example.argumentCaptor;

import java.time.LocalDate;

public class Book {
    private String bookId;
    private String title;
    private int price;
    private LocalDate localDate;

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
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                '}';
    }
}
