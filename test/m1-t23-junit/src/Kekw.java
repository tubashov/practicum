import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Kekw {

    static IntFunction<Integer> mult2 = x -> x * 2;

    static IntFunction<IntFunction<IntFunction<IntFunction<Integer>>>> f = x -> a -> b -> c -> a * x*x + b * x + c;

    // 2, 3, 5, 7 => 3 * 2^2 + 5*2 + 7 = 3 * 4 + 10 + 7 = 12 + 17 = 29

    public static void main(String[] args) {
        System.out.println(f.apply(2).apply(3).apply(5).apply(6));

        Stream.of("kek", "cheburek").filter(a -> a.equals("kek"));
    }
}
