package ro.uvt.commands;

import ro.uvt.model.Book;
import ro.uvt.services.BooksService;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    public List<Book> execute() {
        return booksService.getAllBooks();
    }
}
