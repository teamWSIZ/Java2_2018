package egzamin;

public class YouTubeVideo {
    String title;
    String url;
    String publisher;

    public YouTubeVideo(String title, String url, String publisher) {
        this.title = title;
        this.url = url;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "YouTubeVideo{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
