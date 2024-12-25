package org.example.mockitoStubbing;

import java.time.LocalDate;

public class BookDto {
    private String title;
    private int price;
    private LocalDate localDate;

    public BookDto(String title, int price, LocalDate localDate) {
        this.title = title;
        this.price = price;
        this.localDate = localDate;
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
}
