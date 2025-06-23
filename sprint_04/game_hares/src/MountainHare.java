public class MountainHare {

    // добавьте переменные и конструктор
    int age;
    double weight;
    int jumpLength;
    //private Object Forest;

    public MountainHare(int age, double weight, int jumpLength) {
        this.age = age;
        this.weight = weight;
        this.jumpLength = jumpLength;
    }

    @Override
    public String toString() {
        return "Заяц-беляк: " +
                "age=" + age +
                ", weight=" + weight +
                ", jumpLength=" + jumpLength +
                ", color=" + Forest.color +
                '.';
    }
}
