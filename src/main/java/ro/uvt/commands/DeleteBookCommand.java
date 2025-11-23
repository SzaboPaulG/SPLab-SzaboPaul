package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class DeleteBookCommand implements Command<Boolean> {
    private final BooksService booksService;
    private final Long id;

    public DeleteBookCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    public Boolean execute() {
        return booksService.deleteBook(id);
    }
}
