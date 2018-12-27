package bjtu.embedded.assignments.gymclub.Model;

public class MyObject {
    private String text;
    private String image;

    public MyObject(String text, String image) {
        this.text = text;
        this.image = image;
    }

    //getters & setters

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
