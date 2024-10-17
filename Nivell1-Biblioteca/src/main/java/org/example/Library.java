package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private List<Book> bookList = new ArrayList<Book>();
    private SortedSet<Book> sortedBookList = new TreeSet<Book>();

    public void addBook(Book book) {
        if (book != null && !isDuplicated(book)) {
            bookList.add(book);
            sortedBookList.add(book);
        }
    }

    private boolean isDuplicated(Book book) {
        boolean found = false;
        int i = 0;
        while(found == false && i < bookList.size()) {
            if (bookList.get(i).getTitle().equals(book.getTitle())) {
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
        return bookList.stream().map(x -> x.getTitle()).collect(Collectors.toList());
    }

    public List<Book> getSortedBookList() {
        return sortedBookList.stream().toList();
    }

    public void printBookList() {
        for(Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }

    public void printSortedBookList() {
        for(Book book : sortedBookList) {
            System.out.println(book.getTitle());
        }
    }

    public Book getBookAtIndex(int index) throws IndexOutOfBoundsException {
        if (bookList.size() <= index) {
            throw new IndexOutOfBoundsException("Book at index does not exist");
        }
        return bookList.get(index);
    }

    public String getBookTitleAtIndex(int index) throws IndexOutOfBoundsException {
        return getBookAtIndex(index).getTitle();
    }

    public String getSortedBookTitleAtIndex(int index) {
        if (sortedBookList.size() <= index) {
            throw new IndexOutOfBoundsException("Book at index does not exist");
        }
        return sortedBookList.stream().map(e -> e.getTitle()).toList().get(index);
    }

    public void addBookAtIndex(int index, Book book) throws IndexOutOfBoundsException {
        if (index > bookList.size()) {
            throw new IndexOutOfBoundsException("Trying to add book to a greater index than expected");
        }
        if (!isDuplicated(book)) {
            bookList.add(index, book);
            sortedBookList.add(book);
        }
    }

    public void removeBook(String title) {
        bookList.removeIf(n-> Objects.equals(n.getTitle(), title));
        sortedBookList.remove(new Book(title));
    }

    public int numberOfBooks() {
        return bookList.size();
    }

    public int numberOfSortedBooks() {
        return sortedBookList.size();
    }
}
