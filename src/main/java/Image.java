

public class Image implements Element {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    public void print() {
        System.out.println("Image with name:" + imageName);
    }

    public void add(Element e) {}
    public void remove(Element e) {}
    public Element get(int index) { return null; }
}

