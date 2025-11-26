
package ro.uvt.observer;
import ro.uvt.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BooksSubject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) { observers.add(o); }
    public void add(Book b) {
        for (Observer o : observers) o.update(b);
    }
}
