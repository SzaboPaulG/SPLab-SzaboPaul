package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.model.Book;
import ro.uvt.repositories.CrudRepository;

import java.util.List;

@Service
public class BooksService {
    private final CrudRepository<Book, Long> booksRepository;

    public BooksService(CrudRepository<Book, Long> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book getBook(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        book.setId(null);
        return booksRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existing = getBook(id);
        if (existing == null) {
            return null;
        }
        book.setId(id);
        return booksRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        Book existing = getBook(id);
        if (existing == null) {
            return false;
        }
        booksRepository.deleteById(id);
        return true;
    }
}
