package SP_Lab;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println(title);
        for (Element e : elements) {
            e.print();
        }
    }

    public void add(Element e) {
        elements.add(e);
    }

    public void remove(Element e) {
        elements.remove(e);
    }

    public Element get(int index) {
        return elements.get(index);
    }

    public String getTitle() {
        return title;
    }
}
