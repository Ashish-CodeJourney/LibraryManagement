package LibraryManagement;

import org.junit.jupiter.api.BeforeEach;

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
}