package view;

import controller.DictionaryController;
import java.util.Scanner;

public class DictionaryView {
    private final DictionaryController controller;
    private final Scanner scanner;

    public DictionaryView(DictionaryController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("======== Dictionary program ========");
        System.out.println("1. Add Word");
        System.out.println("2. Delete Word");
        System.out.println("3. Translate");
        System.out.println("4. Exit");
    }

    public void run() {
        controller.model.loadData();

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addWord();
                case 2 -> deleteWord();
                case 3 -> translateWord();
                case 4 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addWord() {
        System.out.println("------------- Add -------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();
        System.out.print("Enter Vietnamese: ");
        String vi = scanner.nextLine();

        if (controller.addWord(eng, vi)) {
            System.out.println("Successful");
        } else {
            System.out.println("Word already exists in the dictionary.");
        }
    }

    private void deleteWord() {
        System.out.println("------------ Delete ------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();

        if (controller.removeWord(eng)) {
            System.out.println("Successful");
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    private void translateWord() {
        System.out.println("------------ Translate ------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();

        String translation = controller.translate(eng);
        System.out.println("Vietnamese: " + translation);
    }
}
