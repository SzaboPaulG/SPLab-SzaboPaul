

public class Paragraph implements Element {
    private String text;
    private alignStrategy AlignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public void print() {
        if (AlignStrategy != null) {
            AlignStrategy.render(text);
        } else {
            System.out.println(text);
        }
    }

    public void setAlignStrategy(alignStrategy strategy) {
        this.AlignStrategy = strategy;
    }

    public void add(Element e) {}
    public void remove(Element e) {}
    public Element get(int index) { return null; }
}

