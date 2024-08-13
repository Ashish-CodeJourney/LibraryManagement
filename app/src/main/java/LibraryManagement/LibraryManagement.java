package LibraryManagement;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryManagement {

    private int borrowCount = 0;

    private Map<String, Book> bookMap;

    public LibraryManagement() {
        bookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        if (bookMap.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("A book with the same ISBN already exists.");
        }
        bookMap.put(book.getIsbn(), book);
    }

    public void borrowBook(Book book) {
        if (borrowCount >= 3) {
            throw new LimitBorrowingException("You cannot borrow more than 3 books.");
        }
    
        Book existingBook = bookMap.get(book.getIsbn());
        if (existingBook != null && existingBook.isAvailable()) {
            existingBook.setAvailable(false);
            borrowCount++;
        } else {
            throw new IllegalArgumentException("Book is not available or does not exist.");
        }
    }
    

    public void returnBook(Book book) {
        Book existingBook = bookMap.get(book.getIsbn());
        if (existingBook != null && !existingBook.isAvailable()) {
            existingBook.setAvailable(true);
        } else {
            throw new IllegalArgumentException("Book is not borrowed or does not exist.");
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
