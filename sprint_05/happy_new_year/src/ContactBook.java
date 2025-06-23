import java.util.ArrayList;

// ограничьте класс ContactBook так, чтобы он мог хранить в себе только список контактов
class ContactBook<T extends Contact> {
    // объявите поле класса contacts — список контактов книги
    Contact contact;
    ArrayList<T> contacts = new ArrayList<>();
    public ContactBook() {
    }
    public void addContact(T contact) {
        contacts.add(contact);
    }

    public void printList() {
//         выведите на экран весь список контактов книги
         for (T contact : contacts) {
            System.out.println("Имя: " + contact.getName());
            contact.print();
        }
    }
    public void congratulate(String name) {
        boolean contactPresented = false; // проверяем, есть ли контакт в базе
        // найдите контакт в книге по имени и отправьте ему сообщение с помощью метода sendMessage()
        for (T contact : contacts) {
            String names = contact.getName();
            if (name.equals(names))  {
                contactPresented = true;
                System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
                contact.sendMessage();
            }
        }
        // если контакт не найден, выведите соответствующее сообщение
        if (!contactPresented) {
        System.out.println("Не найден контакт с указанным именем.");
        }
    }
}