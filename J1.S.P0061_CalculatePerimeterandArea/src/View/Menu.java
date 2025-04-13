/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> menuOptions;
    private boolean continueExecution = true;

    public Menu() {
    }

    public Menu(String title, T[] menuOptions) {
        this.title = title;
        this.menuOptions = new ArrayList<>();
        for (T option : menuOptions) {
            this.menuOptions.add(option);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("--------");
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println((i + 1) + ": " + menuOptions.get(i));
        }
        System.out.println("--------");
    }

    public int getSelected() {
        int selectedOption;
        while (true) {
            display();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter selection: ");
            String input = scanner.nextLine();
            try {
                selectedOption = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please try again.");
            }
        }
        return selectedOption;
    }

    public abstract void execute(int n);
    
    public void exitMenu() {
        continueExecution = false;
    }
    
    public void run() {
        int menuSize = menuOptions.size();
        do {
            int n = getSelected();
            if (n >= 1 && n <= menuSize) {
                execute(n);
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        } while (continueExecution);
    }
}
