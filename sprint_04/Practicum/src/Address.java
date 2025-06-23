import java.util.Arrays;
import java.util.Objects;

public class Address {
    public String city;
    public String street;
    public int houseNumber;
    public String extraInfo;
    public String[] residents;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", extraInfo='" + extraInfo + '\'' +
                ", residents=" + Arrays.toString(residents) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(extraInfo, address.extraInfo)
                && Objects.deepEquals(residents, address.residents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, houseNumber, extraInfo, Arrays.hashCode(residents));
    }
}
