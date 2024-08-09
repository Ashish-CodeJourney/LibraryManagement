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

    public List<Book> getAvailableBooks() {
        return new ArrayList<>(books);
    }

}