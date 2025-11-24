package ro.uvt.repositories;

import org.springframework.stereotype.Component;
import ro.uvt.model.Book;

import java.util.List;
import java.util.Optional;

@Component
public class BooksRepositoryAdapter implements CrudRepository<Book, Long> {
    private final BooksRepository booksRepository;

    public BooksRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return booksRepository.findById(id);
    }

    public Book save(Book entity) {
        return booksRepository.save(entity);
    }

    public void deleteById(Long id) {
        booksRepository.deleteById(id);
    }
}
