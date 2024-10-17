package org.example;

public class Book implements Comparable<Book> {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
}
