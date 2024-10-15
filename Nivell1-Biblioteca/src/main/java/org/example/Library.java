package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private List<Book> bookList = new ArrayList<Book>();
    private SortedSet<Book> sortedBookList = new TreeSet<Book>();

    public void addBook(Book book) {
        if (!isDuplicated(book)) {
            bookList.add(book);
            sortedBookList.add(book);
        }
    }

    private boolean isDuplicated(Book book) {
        boolean found = false;
        int i = 0;
        while(found == false && i < bookList.size()) {
            if (bookList.get(i).title.equals(book.title)) {
                found = true;
            }
            i++;
        }
        return found;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<String> getTitleList() {
        return bookList.stream().map(x -> x.title).collect(Collectors.toList());
    }

    public List<Book> getSortedBookList() {
        return sortedBookList.stream().toList();
    }

    public void printBookList() {
        for(Book book : bookList) {
            System.out.println(book.title);
        }
    }

    public void printSortedBookList() {
        for(Book book : sortedBookList) {
            System.out.println(book.title);
        }
    }

    public Book getBookAtIndex(int index) {
        return bookList.get(index);
    }

    public String getBookTitleAtIndex(int index) {
        return bookList.get(index).title;
    }

    public String getSortedBookTitleAtIndex(int index) {
        return sortedBookList.stream().map(e -> e.title).toList().get(index);
    }

    public void addBookAtIndex(int index, Book book) {
        if (!isDuplicated(book)) {
            bookList.add(index, book);
            sortedBookList.add(book);
        }
    }

    public void removeBook(String title) {
        bookList.removeIf(n-> Objects.equals(n.title, title));
        sortedBookList.remove(new Book(title));
    }

    public int numberOfBooks() {
        return bookList.size();
    }

    public int numberOfSortedBooks() {
        return sortedBookList.size();
    }
}
