/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.TaskManagementController;
import Model.Task;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84945
 */
public class TaskManagementView extends Menu<String> {
    
    Scanner sc = new Scanner(System.in);
    TaskManagementController taskManagementController = new TaskManagementController();
    
    public TaskManagementView(String td, String[] mc) {
        super(td, mc);
    }
    
    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        int id = 1;
        switch (n) {
            case 1: {
                try {
                    taskManagementController.addTask(id);
                    id++;
                } catch (ParseException ex) {
                    Logger.getLogger(TaskManagementView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2:
                taskManagementController.deleteTask(id);
                id--;
                break;
            case 3:
                taskManagementController.getDataTask();
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
