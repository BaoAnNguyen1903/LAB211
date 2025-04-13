/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SalaryHistory;
import Model.Worker;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class WorkerManagementController {

    private final List<Worker> workers = new ArrayList<>();
    private final List<SalaryHistory> salaryHistory = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void addWorker() throws ParseException, IOException {
        String code = null;
        boolean validCode = false;
        while (!validCode) {
            System.out.print("Enter Code: ");
            try {
                code = sc.nextLine();
                if (!code.isEmpty()) {
                    if (!isWorkerIdExists(code)) {
                        validCode = true;
                    } else {
                        System.err.print("Code " + code + " is duplicate.");
                        System.out.print("Re-enter Code: ");
                    }
                } else {
                    System.err.println("Code is not null.");
                }
            } catch (Exception e) {
                System.err.println("Code is not null.");
                sc.nextLine();
            }
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            System.out.print("Enter Age: ");
            try {
                age = sc.nextInt();
                if (age >= 18 && age <= 50) {
                    validAge = true;
                } else {
                    System.err.println("Age must be in range 18 to 50");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Age must be an integer.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        double salary = 0;
        boolean validSalary = false;
        while (!validSalary) {
            System.out.print("Enter Salary: ");
            try {
                salary = sc.nextDouble();
                if (salary > 0) {
                    validSalary = true;
                } else {
                    System.err.println("Salary must be greater than 0.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Salary must be double.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Enter work location: ");
        String wLocation = sc.nextLine();
        Worker worker = new Worker(code, name, age, salary, wLocation);
        workers.add(worker);
        System.out.println("Add Worker success!");
    }

    public void increaseSalary(){
        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        Worker worker = getWorkerById(code);
        if (worker == null) {
            System.err.println("Worker not found. Please try again.");
            return;
        }
        System.out.print("Enter the salary increase amount: ");
        double increaseAmount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Date: ");
        String date = sc.nextLine();
        double oldSalary = worker.getSalary();
        double newSalary = oldSalary + increaseAmount;
        worker.setSalary(newSalary);
        SalaryHistory history = new SalaryHistory(code, oldSalary, newSalary, date);
        salaryHistory.add(history);
        System.out.println("Salary increased successfully.");
    }
    
    public void decreaseSalary(){
        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        Worker worker = getWorkerById(code);
        if (worker == null) {
            System.err.println("Worker not found. Please try again.");
            return;
        }
        System.out.print("Enter the salary decrease amount: ");
        double decreaseAmount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Date: ");
        String date = sc.nextLine();
        double oldSalary = worker.getSalary();
        double newSalary = oldSalary - decreaseAmount;
        worker.setSalary(newSalary);
        SalaryHistory history = new SalaryHistory(code, oldSalary, newSalary, date);
        salaryHistory.add(history);
        System.out.println("Salary decreased successfully.");
    }

    public void showAdjustedSalaries() {
        if (salaryHistory.isEmpty()) {
            System.out.println("No salary adjustments found.");
            return;
        }

        for (SalaryHistory history : salaryHistory) {
            String workerId = history.getwCode();
            Worker worker = getWorkerById(workerId);

            if (worker == null) {
                System.out.println("Worker not found for ID: " + workerId);
                continue;
            }
            String status = null;
            if(history.getNewSalary() > history.getOldSalary()){
                status = "UP";
            }else{
                status = "DOWN";
            }
            System.out.println("Code\t" + "Name\t" + "Age\t" + "Salary\t" + "Status\t" + "Date");
            System.out.println(workerId + "\t" + worker.getName()
                    + "\t" + history.getNewSalary() + "\t" + status + "\t" + history.getDate());
        }
    }

    private boolean isWorkerIdExists(String code) {
        for (Worker worker : workers) {
            if (worker.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public Worker getWorkerById(String code) {
        for (Worker worker : workers) {
            if (worker.getCode().equals(code)) {
                return worker;
            }
        }
        return null;
    }
}
