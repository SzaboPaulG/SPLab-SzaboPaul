package ro.uvt.services;

import ro.uvt.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBook(Long id) {
        return books.get(id);
    }

    public Book createBook(Book book) {
        long id = nextId.getAndIncrement();
        Book stored = new Book(id, book.getTitle(), book.getAuthor());
        books.put(id, stored);
        return stored;
    }

    public Book updateBook(Long id, Book book) {
        if (!books.containsKey(id)) {
            return null;
        }
        Book updated = new Book(id, book.getTitle(), book.getAuthor());
        books.put(id, updated);
        return updated;
    }

    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }
}
