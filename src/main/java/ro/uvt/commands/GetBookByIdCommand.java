package ro.uvt.commands;

import ro.uvt.model.Book;
import ro.uvt.services.BooksService;

public class GetBookByIdCommand implements Command<Book> {
    private final BooksService booksService;
    private final Long id;

    public GetBookByIdCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    public Book execute() {
        return booksService.getBook(id);
    }
}
