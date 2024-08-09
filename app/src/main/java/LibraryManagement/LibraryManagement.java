package LibraryManagement;

import java.util.List;
import java.util.ArrayList;

public class LibraryManagement {

    private List<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAvailableBooks() {
        return new ArrayList<>(books);
    }

}