/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class Validate {
    Scanner sc = new Scanner(System.in);
    
    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                
            } else {
                return result;
            }
        }
    }
    
    public double checkInputSalary() {
        double salary = 0;
        boolean validSalary = false;
        while (!validSalary) {
            try {
                salary = sc.nextDouble();
                if (salary > 0) {
                    validSalary = true;
                } else {
                    System.err.println("Salary is greater than zero.");
                }
            } catch (Exception e) {
                System.err.println("You must input digit.");
                sc.nextLine();
            }
        }
            return salary;
    }
}
