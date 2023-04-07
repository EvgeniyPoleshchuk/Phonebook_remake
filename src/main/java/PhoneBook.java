import java.util.*;

public class PhoneBook {

    public Map<String, List<Contact>> phoneBook = new HashMap<>();

    public void addGroup(String name) {
        if (name != null && name.length() >= 1) {
            phoneBook.put(name, new ArrayList<>());
        }

    }

    public void addContactInGroup(String[] groupName, Contact contact) {
        for (String s : groupName) {
            if (!phoneBook.containsKey(s)) {
                System.out.println("Такой группы не существует");
            } else {
                List<Contact> contacts = phoneBook.get(s);
                if(contact != null) {
                    contacts.add(contact);
                }
            }
        }
    }

    public void printPhoneBook() {

        System.out.println(phoneBook.toString());
    }


    public String search(String nameGroup) {
        if (phoneBook.containsKey(nameGroup)) {
            return phoneBook.get(nameGroup).toString();
        } else {
            return null;
        }
    }

    public Contact searchPhoneNumber(String number) {
        for (Map.Entry<String, List<Contact>> kv : phoneBook.entrySet()) {
            for (Contact list : kv.getValue()) {
                if (number.equals(list.getPhoneNumber())) {
                    return list;
                }
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Phonebook " + phoneBook.toString();
    }
}











