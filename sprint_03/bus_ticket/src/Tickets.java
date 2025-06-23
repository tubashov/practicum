public class Tickets {

    public static void main(String[] args) {
        Bus bus = new Bus(23765); // новый объект класса bus c типом int
        String[] passengersTimestamps = new String[]{
                "08:33",
                "09:42",
                "10:43",
                "17:59",
                "18:01",
                "19:15"
        };

        for (int i = 0; i < passengersTimestamps.length; i++) {
            increaseTicketNumber(bus);
            System.out.println("Оплата поездки в " + passengersTimestamps[i]
                    + ". Номер билета: " + bus.ticketNumber);
        }
    }

    private static void increaseTicketNumber(Bus bus) { // метод присвоение номера билета
        bus.ticketNumber = bus.ticketNumber + 1; // вставьте код для увеличения номера билета
    }

}

class Bus {
    public Bus(int initialNumber) { // метод  присваивает переменной ticketNumber значение аргумента initialNumber
        ticketNumber = initialNumber; // аргумент задается в методе main при создании объекта класса bus
    }

    int ticketNumber;
}