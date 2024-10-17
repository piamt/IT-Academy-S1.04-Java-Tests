package org.example;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        for (int i = 0; i < 10; i++) {
            library.addBook(new Book("Book" + i));
        }

        try {
            Book book = library.getBookAtIndex(10);
            System.out.println(book.getTitle());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }
}