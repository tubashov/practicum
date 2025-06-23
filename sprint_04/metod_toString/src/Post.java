import java.util.ArrayList;
import java.util.Arrays;

public class Post extends PostComment {
    private String title; // заголовок
    private String content; // содержание
    private String[] tags; // теги
    private ArrayList<PostComment> comments; //комментарии

    public Post(String title, String content, String[] tags, ArrayList<PostComment> comments) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.comments = comments;
    }
    /* Вывод должен получиться таким:
    Post{title='xxx', content.length='x', tags=[x,x],
    comments=[PostComment{text='x!', whoLiked=[x, x]},
    PostComment{text='x', whoLiked=[x,x]},
    PostComment{text='x', whoLiked=null}]} */

    PostComment postComment = new PostComment();

    public Post() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setComments(ArrayList<PostComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        String result = "Post{" +
                "title='" + title + '\'' +
                ", content.length='" + content.length() + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", comments=" + comments;
        return result;
    }

}

