import java.util.Objects;

public class Actor {
    String firstName;
    String lastName;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null) return false;
        Actor otheractor = (Actor) a;
        return Objects.equals(firstName, otheractor.firstName) &&
                Objects.equals(lastName, otheractor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName);
    }
}

