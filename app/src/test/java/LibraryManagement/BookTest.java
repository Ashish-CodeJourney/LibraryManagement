package LibraryManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("123456789", "Clean Code", "Robert C. Martin", 2008);
    }

    @Test
    void Test_BookCreation () {
        assertEquals("123456789", book.getIsbn());
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals(2008, book.getPublicationYear());
        assertTrue(book.isAvailable());
    }

    @Test
    void Test_SetAvailable () {
        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }

    @Test
    void Test_InvalidIsbn_ThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Valid Title", "Valid Author", 2022);
        });
        assertEquals("ISBN cannot be null or empty.", exception.getMessage());
    }
}
