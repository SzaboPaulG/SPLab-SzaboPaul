package ro.uvt.commands;

import ro.uvt.model.Book;
import ro.uvt.services.BooksService;

public class UpdateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Long id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, Long id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    public Book execute() {
        return booksService.updateBook(id, book);
    }
}
