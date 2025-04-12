/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NumberList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class EquationController {

    NumberList numList = new NumberList();
    AlgorithmEquation algoritm = new AlgorithmEquation();
    Scanner sc = new Scanner(System.in);

    public void CalSuperlativeEquation() {
        System.out.println("----- Calculate Superlative Equation -----");
        float numA = 0;
        boolean validNumA = false;
        while (!validNumA) {
            System.out.print("Enter A: ");
            try {
                numA = sc.nextFloat();
                numList.setNumA(numA);
                validNumA = true;
            } catch (Exception e) {
                System.err.println("Please input number.");
                sc.nextLine();
            }
        }
        float numB = 0;
        boolean validNumB = false;
        while (!validNumB) {
            System.out.print("Enter B: ");
            try {
                numB = sc.nextFloat();
                numList.setNumB(numB);
                validNumB = true;
            } catch (Exception e) {
                System.err.println("Please input number.");
                sc.nextLine();
            }
        }
        List<Float> superlativeSolutions = algoritm.calculateEquation(numList.getNumA(), numList.getNumB());
        algoritm.displaySolutions(superlativeSolutions);
        algoritm.displayOddNumbers(numList.getNumA(), numList.getNumB());
        algoritm.displayEvenNumbers(numList.getNumA(), numList.getNumB());
        algoritm.displayPerfectSquareNumbers(numList.getNumA(), numList.getNumB());
    }

    public void CalQuadraticEquation() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float numA = 0;
        boolean validNumA = false;
        while (!validNumA) {
            System.out.print("Enter A: ");
            try {
                numA = sc.nextFloat();
                numList.setNumA(numA);
                validNumA = true;
            } catch (Exception e) {
                System.err.println("Please input number.");
                sc.nextLine();
            }
        }
        float numB = 0;
        boolean validNumB = false;
        while (!validNumB) {
            System.out.print("Enter B: ");
            try {
                numB = sc.nextFloat();
                numList.setNumB(numB);
                validNumB = true;
            } catch (Exception e) {
                System.err.println("Please input number.");
                sc.nextLine();
            }
        }
        float numC = 0;
        boolean validNumC = false;
        while (!validNumC) {
            System.out.print("Enter C: ");
            try {
                numC = sc.nextFloat();
                numList.setNumC(numC);
                validNumC = true;
            } catch (Exception e) {
                System.err.println("Please input number.");
                sc.nextLine();
            }
        }
        List<Float> quadraticSolutions = algoritm.calculateQuadraticEquation(numList.getNumA(), numList.getNumB(), numList.getNumC());
        algoritm.displaySolutions(quadraticSolutions);
        algoritm.displayOddNumbers(numList.getNumA(), numList.getNumB(), numList.getNumC());
        algoritm.displayEvenNumbers(numList.getNumA(), numList.getNumB(), numList.getNumC());
        algoritm.displayPerfectSquareNumbers(numList.getNumA(), numList.getNumB(), numList.getNumC());
    }

}
