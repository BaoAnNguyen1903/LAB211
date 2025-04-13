/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.WorkerManagementController;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84945
 */
public class WorkerView extends Menu<String> {

    Scanner sc = new Scanner(System.in);
    WorkerManagementController workerController = new WorkerManagementController();

    public WorkerView(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1:
                System.out.println("--------- Add Worker ---------");
                 {
                    try {
                        workerController.addWorker();
                    } catch (ParseException ex) {
                        Logger.getLogger(WorkerView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(WorkerView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 2:
                System.out.println("--------- Up/Down Salary ---------");
                workerController.increaseSalary();
                break;
            case 3:
                System.out.println("--------- Up/Down Salary ---------");
                workerController.decreaseSalary();
                break;
            case 4:
                System.out.println("--------- Display Information Salary ---------");
                workerController.showAdjustedSalaries();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;
        }
    }
}
