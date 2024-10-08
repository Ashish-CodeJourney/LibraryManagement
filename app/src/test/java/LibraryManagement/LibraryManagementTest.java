package LibraryManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryManagementTest {

    private LibraryManagement library;

    @BeforeEach
    void setUp() {
        library = new LibraryManagement();
    }

    @Test
    void Test_Adding_Book () {

        Book book = new Book("123456789", "Clean Code", "Robert C. Martin", 2008);

        library.addBook(book);

        assertEquals(1, library.getAvailableBooks().size());
        assertTrue(library.getAvailableBooks().contains(book));
    }

    @Test
    void Test_Adding_Duplicate_Book() {
        Book book1 = new Book("123456789", "Clean Code", "Robert C. Martin", 2008);
        Book book2 = new Book("123456789", "Clean Architecture", "Robert C. Martin", 2017);

        library.addBook(book1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(book2);
        });

        assertEquals("A book with the same ISBN already exists.", exception.getMessage());
    }

    @Test
    void Test_Borrowing_Book () {

        Book book = new Book("123456789", "Clean Code", "Robert C. Martin", 2008);

        // Addding the book first
        library.addBook(book);

        // Borrowing that book
        library.borrowBook(book);

        assertEquals(0, library.getAvailableBooks().size()); // Should have no available books after borrowing
        assertFalse(book.isAvailable());
    }

    @Test
    void Test_Borrowing_Unavailable_Book() {
        Book book = new Book("123456789", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book);
        library.borrowBook(book);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook(book);
        });

        assertEquals("Book is not available or does not exist.", exception.getMessage());
    }

    @Test
    void Test_Returning_Book () {

        Book book = new Book("123456789", "Clean Code", "Robert C. Martin", 2008);

        // Addding the book first
        library.addBook(book);

        // Borrowing that book
        library.borrowBook(book);

        // Returning borrowed book
        library.returnBook(book);

        assertEquals(1, library.getAvailableBooks().size()); 
        assertTrue(book.isAvailable());
    }

    @Test
    void Test_Returning_NonBorrowed_Book() {
        Book book = new Book("123456789", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook(book);
        });

        assertEquals("Book is not borrowed or does not exist.", exception.getMessage());
    }

    @Test 
    void Test_ViewAvailableBooks () {
        Book book1 = new Book("111111111", "Working Effectively with Legacy Code", "Michael C. Feathers", 2005);
        Book book2 = new Book("222222222", "Clean Code", "Robert C. Martin", 2008);
        Book book3 = new Book("333333333", "The class of Java", "Pravin Jain", 2010);


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> availableBooks = library.getAvailableBooks();

        assertEquals(3, availableBooks.size()); // Should have two available books
        assertTrue(availableBooks.contains(book1));
        assertTrue(availableBooks.contains(book2));
        assertTrue(availableBooks.contains(book3));
    }

    @Test
    void Test_NotBorrowing_more_then_3_books () {
        Book book1 = new Book("111111111", "Working Effectively with Legacy Code", "Michael C. Feathers", 2005);
        Book book2 = new Book("222222222", "Clean Code", "Robert C. Martin", 2008);
        Book book3 = new Book("333333333", "The class of Java", "Pravin Jain", 2010);
        Book book4 = new Book("444444444", "Working Effectively with Legacy Code", "Michael C. Feathers", 2005);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.borrowBook(book1);
        library.borrowBook(book2);
        library.borrowBook(book3);

        LimitBorrowingException exception = assertThrows(
            LimitBorrowingException.class, 
            () -> library.borrowBook(book4)
        );

        assertEquals("You cannot borrow more than 3 books.", exception.getMessage());

    }
}