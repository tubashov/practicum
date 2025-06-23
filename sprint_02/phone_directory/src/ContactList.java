import java.util.ArrayList;

public class ContactList {
    public ArrayList<Contact> contacts = new ArrayList<>();
    public int limit; // поле "лимит справочника"

    public ContactList(int aLimit) { // конструктор "лимит справрчника"
        limit = aLimit;
    }
    public void addContact(String name, String phone) { // метод добавления контакта
        if (contacts.size() ==  limit) {
            System.out.println("Справочник полон, добавление невозможно");
            return;
        }
        Contact contact = new Contact(name, phone);
        contacts.add(contact); // добавление контакта в ArrayList
    }

    public Contact findContactByName(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(name)) {
                return contact;
            }

        }
        return  null;
    }

    public void printAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Справочник пуст, контактов нет");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println(contact.getName() + " - " + contact.getPhone());

        }
    }
}
