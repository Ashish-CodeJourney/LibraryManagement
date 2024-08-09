package LibraryManagement;

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
}