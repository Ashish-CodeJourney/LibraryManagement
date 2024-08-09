package LibraryManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

    // Dummy data of a book for Testing
    private String isbn = "123456789";
    private String title = "Clean Code";
    private String author = "Robert C. Martin";
    private int publicationYear = 2008;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(isbn, title, author, publicationYear);
    }

    @Test
    void Test_BookCreation () {
        assertEquals(isbn, book.getIsbn());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(publicationYear, book.getPublicationYear());
        assertTrue(book.isAvailable());
    }

    @Test
    void Test_SetAvailable () {
        book.setAvailable(false);

        assertFalse(book.isAvailable());
    }
}