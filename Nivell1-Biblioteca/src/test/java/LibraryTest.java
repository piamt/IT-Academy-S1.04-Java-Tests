import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.Book;
import org.example.Library;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    Library library;

    @BeforeAll
    static void initAll() {

    }

    @BeforeEach
    void init() {
        library = new Library();
    }

    @Test
    public void bookListNotNull() {
        Assertions.assertNotNull(library.getBookList());
        Assertions.assertNotNull(library.getSortedBookList());
    }

    @Test
    public void bookListHasExpectedSize() {
        add10BooksToLibrary();

        assertEquals(10, library.numberOfBooks());
        assertEquals(10, library.numberOfSortedBooks());
    }

    @Test
    public void expectedBookAtPosition() {
        add10BooksToLibrary();
        Book book = new Book("My book at position 3");
        library.addBookAtIndex(3, book);

        assertEquals(book, library.getBookAtIndex(3));
    }

    @Test
    public void expectedTitleAtPosition() {
        add10BooksToLibrary();

        assertEquals("Book9", library.getBookTitleAtIndex(9));
    }

    @Test
    public void noDuplicatesInBookList() {
        add10BooksToLibrary();
        library.addBook(new Book("Book4"));

        assertEquals(10, library.numberOfBooks());
    }

    @Test
    public void expectedListAfterAddingNewBook() {
       add10BooksToLibrary();
        library.addBook(new Book("BookNew"));
        library.addBookAtIndex(5, new Book("Book at index 5"));

        List<String> list = Arrays.asList("Book0", "Book1", "Book2", "Book3", "Book4", "Book at index 5", "Book5", "Book6", "Book7", "Book8", "Book9", "BookNew");
        assertEquals( library.getTitleList(), list);
    }

    @Test
    public void expectedSizeAfterBookRemoved() {
        add10BooksToLibrary();
        library.removeBook("Book8");

        assertEquals(9, library.numberOfBooks());
    }

    @Test
    public void expectedAlphabeticalOrderAfterBookAdded() {
        add10BooksToLibrary();
        library.addBook(new Book("BookNew"));

        checkExpectedOrder();
    }

    @Test
    public void expectedAlphabeticalOrderAfterBookRemoved() {
        add10BooksToLibrary();
        library.removeBook("Book8");

        checkExpectedOrder();
    }

    @Test
    public void expectedBookListSameSize() {
        add10BooksToLibrary();
        library.removeBook("Book8");
        library.addBookAtIndex(3, new Book("New book"));

        assertEquals(library.getBookList().size(), library.getSortedBookList().size());
    }

    private void add10BooksToLibrary() {
        for (int i = 0; i < 10; i++) {
            library.addBook(new Book("Book" + i));
        }
    }

    private void checkExpectedOrder() {
        List<Book> orderedList = library.getSortedBookList();
        for (int i = 0; i < (orderedList.size() - 1); i++) {
            assertTrue(orderedList.get(i).compareTo(orderedList.get(i+1)) < 0);
        }
    }

    @AfterEach
    void tearDown() {
        library = null;
    }

    @AfterAll
    static void tearDownAll() {
    }
}
