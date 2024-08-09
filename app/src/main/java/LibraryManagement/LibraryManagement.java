package LibraryManagement;

import java.util.List;
import java.util.ArrayList;

public class LibraryManagement {

    private List<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                throw new IllegalArgumentException("A book with the same ISBN already exists.");
            }
        }
        books.add(book);
    }

    public void borrowBook(Book book) {
        if (books.contains(book) && book.isAvailable()) {
            book.setAvailable(false);
        } else {
            throw new IllegalArgumentException("Book is not available or does not exist.");
        }
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

}