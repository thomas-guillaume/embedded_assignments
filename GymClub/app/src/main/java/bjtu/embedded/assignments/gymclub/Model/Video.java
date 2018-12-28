package bjtu.embedded.assignments.gymclub.Model;

public class Video {

    private String image;
    private String description;
    private String url;


    public Video(String image, String description, String url) {
        this.image = image;
        this.description = description;
        this.url = url;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
