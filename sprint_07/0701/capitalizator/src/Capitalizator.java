public class Capitalizator {
    public String capitalize(String str) {
        String newStr = str.substring(0, 1).toUpperCase() + str.substring(1);
        return newStr;
    }
}