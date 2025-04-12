package controller;

import Person.Person;
import java.util.List;
import java.util.Scanner;
import model.FileProcessorModel;
import view.FileProcessorView;

public class FileProcessorController {
    private final FileProcessorModel model;
    private final FileProcessorView view;

    public FileProcessorController(FileProcessorModel model, FileProcessorView view) {
        this.model = model;
        this.view = view;
    }

    public void processOption(int option) {
        switch (option) {
            case 1 -> findPersonInfo();
            case 2 -> copyTextToNewFile();
            case 3 -> {
                System.out.println("Exiting...");
                System.exit(0);
            }
            default -> System.out.println("Invalid option");
        }
    }

    private void findPersonInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Path: ");
        String path = scanner.nextLine();
        System.out.print("Enter Money: ");
        double money = scanner.nextDouble();
        try {
            List<Person> people = model.getPerson(path, money);
            view.displayPersonInfo(people);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void copyTextToNewFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Source: ");
        String source = scanner.nextLine();
        System.out.print("Enter new file name: ");
        String destination = scanner.nextLine();
        try {
            boolean status = model.copyWordOneTimes(source, destination);
            view.displayCopyStatus(status);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
