
package ro.uvt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.observer.*;

@RestController
public class BooksSseController {
    private final BooksSubject subject;

    public BooksSseController(BooksSubject subject) {
        this.subject = subject;
    }

    @GetMapping("/books-sse")
    public SseEmitter stream() {
        SseEmitter emitter = new SseEmitter(0L);
        subject.attach(new SseObserver(emitter));
        return emitter;
    }
}
