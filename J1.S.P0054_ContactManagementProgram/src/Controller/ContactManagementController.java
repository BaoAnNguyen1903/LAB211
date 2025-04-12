/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class ContactManagementController {

    Contact contact = new Contact();
    private List<Contact> contacts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    
    public void addContact(String fullName, String group, String address, String phone) {
    // Validate phone number format
    while (!phone.matches(VALID_PHONE)) {
        System.out.println("Invalid phone number format! Please enter a valid phone number.");
        System.out.print("Enter Phone: ");
        phone = sc.nextLine();
    }

    Contact contact = new Contact(fullName, group, address, phone);
    contacts.add(contact);
    System.out.println("Contact added successfully!");
}

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.err.println("No contacts found.");
            return;
        }
        System.out.println("ID\tName\t\tFirst Name\tLast Name\tGroup\tAddress\tPhone");
        for (Contact contact : contacts) {
            System.out.println(contact.getId() + "\t" + contact.getFullName() + "\t"
                    + contact.getFirstName() + "\t\t" + contact.getLastName() + "\t\t"
                    + contact.getGroup() + "\t" + contact.getAddress() + "\t" + contact.getPhone());
        }
    }

    public void deleteContact(int id) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                found = true;
                System.out.println("Contact deleted successfully!");
                break;
            }
        }
        if (!found) {
            System.err.println("No contact found with ID: " + id);
        }
    }
}
