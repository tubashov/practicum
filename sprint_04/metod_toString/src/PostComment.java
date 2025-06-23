import java.util.Arrays;

public class PostComment {
    private String text; // содержание комментария
    private String[] whoLiked; // кто поддержал

    public PostComment() {};
    public PostComment(String text, String[] whoLiked) {
        this.text = text;
        this.whoLiked = whoLiked;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setWhoLiked(String[] whoLiked) {
        this.whoLiked = whoLiked;
    }
    @Override
    public String toString() {
        String result = "PostComment{" +
                "text='" + text + '\'' +
                ", whoLiked=" + Arrays.toString(whoLiked);
        return result;
    }
}
