import java.util.Objects;

public class Movie {
    String title; // название фильма
    int releaseYear; // год выхода на экраны

    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object m) {
        if (this == m) return true;
        if (m == null) return false;
        Movie othermovie = (Movie) m;
        return Objects.equals(title, othermovie.title) &&
                Objects.equals(releaseYear, othermovie.releaseYear);
    }
       @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
    public String description() { // метод для вывода описания фильма
        return  '"' + title + "\" (" + releaseYear + " год)";
    }
}