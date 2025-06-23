// дополните объявление класса Contact
public abstract class Contact {
    // класс должен содержать одно полe — имя пользователя name
    public final String name;

    public Contact(String name) {
        this.name = name;
    }
    // и два три метода — getName(), sendMessage() для отправки сообщения и print() для печати информации о контакте
    public String getName() {
        return name;
    }
    public abstract void sendMessage();
    public abstract void print();
}