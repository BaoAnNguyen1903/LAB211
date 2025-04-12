
package view;

import Person.Person;
import java.util.List;

public class FileProcessorView {
    public void displayMenu() {
        System.out.println("========== File Processing =========");
        System.out.println("1. Find person info");
        System.out.println("2. Copy Text to new file");
        System.out.println("3. Exit");
        System.out.println("------------------------------------");
    }

    public void displayPersonInfo(List<Person> people) {
        System.out.println("------------- Person info -------------");
        System.out.printf("%-20s %-20s %-20s%n", "Name", "Address", "Money");
        for (Person person : people) {
            System.out.printf("%-20s %-20s %-20.1f%n", person.getName(), person.getAddress(), person.getSalary());
        }
        System.out.println("---------------------------------------");
    }

    public void displayCopyStatus(boolean status) {
        if (status) {
            System.out.println("Copy done...");
        } else {
            System.out.println("Copy failed...");
        }
    }
}
