import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


public class Practicum {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(1000) + 1;
        System.out.println("Я загадал число. Попробуйте угадать!");


        Scanner s = new Scanner(System.in);
        int userGuess = -1;

        //Arrays.binarySearch().
        // Считывайте числа от пользователя пока не найдёте число, равное target
        int[] array = new int[1000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            // System.out.println(array[i]);
        }
        while (userGuess != target){

            userGuess = s.nextInt();
            if (userGuess < target) {
                System.out.println("Ваше число меньше");
            } else if (userGuess > target) {
                System.out.println("Ваше число больше");
            } else if ( userGuess == target) {
                System.out.println("Правильный ответ");
                break;
            }
        }


    }
}