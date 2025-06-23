import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contacts = new ContactList(3);

        while (true) {
            printMenu();

            int cmd = scanner.nextInt();
            if (cmd == 1) {
                System.out.print("Введите имя контакта: ");
                String name = scanner.next();
                System.out.print("Введите номер телефона: ");
                String phone = scanner.next();
                contacts.addContact(name, phone);
            } else if (cmd == 2) {
                System.out.print("Введите имя для поиска: ");
                String name = scanner.next();
                Contact contact = contacts.findContactByName(name);
                if (contact != null) {
                    System.out.println("Контакт найден" + contact.getPhone());
                } else {
                    System.out.println("Контакт не найден");
                }
            } else if (cmd == 3) {
                contacts.printAllContacts();
            } else if (cmd == 4) {
                return;
            } else {
                System.out.println("Такой команды нет");
            }
            System.out.println();
            System.out.println("----------");
            System.out.println();
        }
    }
    public static void printMenu() {
        System.out.println("Выберите номер операции");
        System.out.println("1. Добавить контакт");
        System.out.println("2. Поиск контакта по имени");
        System.out.println("3. Вывод всех контактов на экран");

    }
}
