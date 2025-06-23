// унаследуйте класс от базового класса, описывающего контакт Contact
class Phone extends Contact {
    private final String phoneNumber;

    public Phone(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

// метод sendMessage переопределяет метод базового класса

    public void sendMessage() {
        System.out.println("Звоним другу по номеру " + phoneNumber + " и зовём на кофе.");
    }

    @Override
    public void print() {
        System.out.println("Номер телефона: " + getPhoneNumber());
    }
}