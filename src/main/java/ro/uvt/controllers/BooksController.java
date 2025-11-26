package ro.uvt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.commands.*;
import ro.uvt.model.Book;
import ro.uvt.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;
    private final ro.uvt.observer.BooksSubject subject;

    public BooksController(ro.uvt.observer.BooksSubject subject, BooksService booksService) {
        this.booksService = booksService;
        this.subject = subject;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        Command<List<Book>> command = new GetAllBooksCommand(booksService);
        return command.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Command<Book> command = new GetBookByIdCommand(booksService, id);
        Book result = command.execute();
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Command<Book> command = new CreateBookCommand(booksService, book);
        Book created = command.execute();
        subject.add(created);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Command<Book> command = new UpdateBookCommand(booksService, id, book);
        Book updated = command.execute();
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Command<Boolean> command = new DeleteBookCommand(booksService, id);
        Boolean deleted = command.execute();
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
