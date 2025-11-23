package ro.uvt.commands;

import ro.uvt.model.Book;
import ro.uvt.services.BooksService;

public class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    public Book execute() {
        return booksService.createBook(book);
    }
}
