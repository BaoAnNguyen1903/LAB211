/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class TaskManagementController {
    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();
    ArrayList<Task> tasks = new ArrayList<>();
    
    public void addTask(int id) throws ParseException {
        System.out.println("----------Add Task----------");
        System.out.print("Enter Requirement Name: ");
        String requirementName = validate.checkInputString();
        System.out.print("Enter Task Type: ");
        String taskTypeId = validate.checkInputTaskTypeId();
        System.out.print("Enter Date: ");
        String date = validate.checkInputDate();
        System.out.print("Enter From: ");
        String planFrom = validate.checkInputPlan();
        System.out.print("Enter To: ");
        String planTo = validate.checkInputPlan();
        System.out.print("Enter Assignee: ");
        String assign = validate.checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = validate.checkInputString();
        Task task = new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer);
        tasks.add(task);
        System.out.println("Add Task Success.");
    }

    public void deleteTask(int id) {
        System.out.println("----------Del Task----------");
        if (tasks.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int findId = findTaskExist();
        if (findId != -1) {
            tasks.remove(findId);
            for (int i = findId; i < tasks.size(); i++) {
                tasks.get(i).setTaskId(tasks.get(i).getTaskId() - 1);
            }
            System.out.println("Delete success.");
        }
    }

    public int findTaskExist() {
        System.out.print("Enter id: ");
        int id = validate.checkInputInt();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }

    public void getDataTask() {
        System.out.println("--------------------Task--------------------");
        if (tasks.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : tasks) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getTaskId(),
                    task.getRequirementName(),
                    task.getTaskIdType(),
                    task.getDate(),
                    Double.parseDouble(task.getPlanTo()) - Double.parseDouble(task.getPlanFrom()),
                    task.getAssign(),
                    task.getReviewer()
            );

        }
    }
}
