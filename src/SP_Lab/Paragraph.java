package SP_Lab;

public class Paragraph implements Element {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Paragraph: " + text);
    }

    public void add(Element e) {}
    public void remove(Element e) {}
    public Element get(int index) { return null; }
}

