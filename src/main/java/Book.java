

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super("Book: " + title);
    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

    public void print() {
        System.out.println(this.getTitle());
        System.out.println();
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        System.out.println();
        for (int i = 0; ; i++) {
            try {
                Element e = get(i);
                e.print();
            } catch (Exception ex) {
                break;
            }
        }
    }
}

