import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> stateHolidays = new HashMap<>(); // создаём хэш-таблицу
        ArrayList<Integer> january = new ArrayList<>(); // создаем список с датами
        january.add(1);
        january.add(7);
        stateHolidays.put("Январь", january);
        ArrayList<Integer> february = new ArrayList<>(); // создаем список с датами
        february.add(23);
        stateHolidays.put("Февраль", february);
        ArrayList<Integer> march = new ArrayList<>(); // создаем список с датами
        march.add(8);
        stateHolidays.put("Март", march);
        ArrayList<Integer> may = new ArrayList<>(); // создаем список с датами
        may.add(1);
        may.add(9);
        stateHolidays.put("Май", may);
        ArrayList<Integer> june = new ArrayList<>(); // создаем список с датами
        june.add(12);
        stateHolidays.put("Июнь", june);
        ArrayList<Integer> november = new ArrayList<>(); // создаем список с датами
        november.add(4);
        stateHolidays.put("Ноябрь", november);
        System.out.println(stateHolidays);
    }
}
