import java.util.Objects;

public class Song {
    public final String title;
    public final String artist;
    public final String songwriter;

    public Song(String title, String artist, String songwriter) {
        this.title = title;
        this.artist = artist;
        this.songwriter = songwriter;
    }

    // переопределите метод equals(Object)
    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true; // проверка ссылок
        if (obj == null) return false; // проверка ссылки на null
        if (this.getClass() != obj.getClass()) return false; // сравниваем классы объектов
        Song ovtherSong = (Song) obj; // приведение объекта к нужному классу
        return Objects.equals(title, ovtherSong.title) &&
                Objects.equals(artist, ovtherSong.artist) &&
                Objects.equals(songwriter, ovtherSong.songwriter);  // сравнивание полей объектов
    }

}
