

public class Table implements Element {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("Table: " + title);
    }

    public void add(Element e) {}
    public void remove(Element e) {}
    public Element get(int index) { return null; }
}
