package LibraryManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryManagementTest {

    // Dummy data of a book for Testing
    private String isbn = "123456789";
    private String title = "Clean Code";
    private String author = "Robert C. Martin";
    private int publicationYear = 2008;

    private LibraryManagement library;

    @BeforeEach
    void setUp() {
        library = new LibraryManagement();
    }

    @Test
    void Test_Adding_Book () {
        String isbn = "123456789";
        String title = "Clean Code";
        String author = "Robert C. Martin";
        int publicationYear = 2008;

        Book book = new Book(isbn, title, author, publicationYear);

        library.addBook(book);

        assertEquals(1, library.getAvailableBooks().size());
        assertTrue(library.getAvailableBooks().contains(book));
    }
}