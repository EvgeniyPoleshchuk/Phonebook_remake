import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    private Contact contact;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;


    @BeforeEach
    void setUp() {
        phoneBook.addGroup("Family");
        contact = new Contact("Jone", "89111111111");
        contact1 = new Contact("Zheka", "89113333333");
        contact2 = new Contact("Dima", "80112222222");
        contact3 = null;

    }

    @Test
    void addGroupIsNotNull() {
        String[] groupName = {"Family", "Job", "Friends", null};


        for (String input1 : groupName) {
            phoneBook.addGroup(input1);
        }
        Assertions.assertNotNull(phoneBook.phoneBook.keySet());
    }

    @Test
    void addContactInGroupIsNotNull() {
        List<Contact> expect = new ArrayList<>();
        expect.add(contact);
        expect.add(contact1);
        expect.add(contact2);
        expect.add(contact3);
        expect.removeIf(Objects::isNull);


        for (Contact a : expect) {
            phoneBook.addContactInGroup(new String[]{"Family"}, a);
        }

        Assertions.assertEquals(expect, phoneBook.phoneBook.get("Family"));


    }

}



