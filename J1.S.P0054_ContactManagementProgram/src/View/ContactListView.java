/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ContactManagementController;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84945
 */
public class ContactListView extends Menu<String> {

    ContactManagementController contactController = new ContactManagementController();
    Scanner sc = new Scanner(System.in);

    public ContactListView(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1:
                System.out.println("-------- Add Contact --------");
                System.out.print("Enter Name: ");
                String fullName = sc.nextLine();
                System.out.print("Enter Group: ");
                String group = sc.nextLine();
                System.out.print("Enter Address: ");
                String address = sc.nextLine();
                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();
                contactController.addContact(fullName, group, address, phone);
                break;

            case 2:
                System.out.println("--------------------------------- Display all Contact ----------------------------");
                contactController.displayContacts();
                break;
            case 3:
                System.out.println("-------- Delete a Contact ---------");
                System.out.println("Enter contact ID to delete:");
                if (sc.hasNextInt()) {
                    int idToDelete = sc.nextInt();
                    contactController.deleteContact(idToDelete);
                } else {
                    System.err.println("Invalid ID format! Please enter a number.");
                    sc.nextLine();
                }
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;
        }
    }
}
