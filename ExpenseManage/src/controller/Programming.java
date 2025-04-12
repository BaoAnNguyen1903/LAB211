package controller;

import java.util.ArrayList;
import model.Expense;
import view.Menu;

/**
 *
 * @author os
 */
public class Programming extends Menu{
    private ArrayList<Expense> listExpense = new ArrayList<>();
    Validation valid = new Validation();
    private int idCounter = 1;
    
    public Programming(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        int id = 1;
        switch (n) {
            case 1:
                addExpense();
                id++;
                break;
            case 2:
                print();
                break;
            case 3:
                deleteExpense();
                break;
            case 4:
                System.exit(0);
        }
    }
    
    public void addExpense() {
        System.out.println("------------Add an expense---------------");
        System.out.print("Enter Date: ");
        String date = valid.checkInputString();
        System.out.print("Enter Amount: ");
        int amount = valid.checkInputInt();
        System.out.print("Enter Content: ");
        String content = valid.checkInputString();
       
        listExpense.add(new Expense(idCounter, date, amount, content));
        idCounter++;
        System.out.println("Add Expense Success.");
    }
    
    public int findExpenseExist() {
        System.out.print("Enter id: ");
        int id = valid.checkInputInt();
        for (int i = 0; i < listExpense.size(); i++) {
            if (listExpense.get(i).getExpenseID()== id) {
                return i;
            }
        }
        System.out.println("Not found.");
        return -1;
    }
    
    public void deleteExpense() {
        System.out.println("--------Delete an expense------");
        if (listExpense.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        int findId = findExpenseExist();
        if (findId != -1) {
            listExpense.remove(findId);
            System.err.println("Delete success.");
        }
    }
    
public void print() {
    if (listExpense.isEmpty()) {
        System.out.println("List empty.");
        return;
    }
    System.out.println("---------Display all expenses------------");
    System.out.printf("%-5s%-15s%-15s%-15s\n",
            "ID", "Date", "Amount", "Content");
    int total = 0;
    for (int i = 0; i < listExpense.size(); i++) {
        System.out.printf("%-5s%-15s%-15s%-15s\n",
                listExpense.get(i).getExpenseID(),
                listExpense.get(i).getDate(),
                listExpense.get(i).getMoney(),
                listExpense.get(i).getContentString());
        total += listExpense.get(i).getMoney();
    }
    System.out.println("Total: " + total);
}
}