/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class AnalyzeStringController {

    Scanner sc = new Scanner(System.in);

    public boolean checkSquareNumber(int n) {
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            return true;
        }
        return false;
    }

    public void getNumber(String inputString) {
        String number = inputString.replaceAll("\\D+", ",");
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);
        }
        String[] listNumber = number.split(",");
        int lenNumber = listNumber.length;
        ArrayList<Integer> liPerfectSquare = new ArrayList<>();
        ArrayList<Integer> liOdd = new ArrayList<>();
        ArrayList<Integer> liEven = new ArrayList<>();
        ArrayList<Integer> liAll = new ArrayList<>();
        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1) {
                liOdd.add(numberCheck);
            }
            if (numberCheck % 2 == 0) {
                liEven.add(numberCheck);
            }
            if (checkSquareNumber(numberCheck)) {
                liPerfectSquare.add(numberCheck);
            }
            liAll.add(numberCheck);
        }
        System.out.println("Perfect Square Numbers: " + liPerfectSquare);
        System.out.println("Odd Numbers: " + liOdd);
        System.out.println("Even Numbers: " + liEven);
        System.out.println("All Numbers: " + liAll);
    }

    public void getCharacter(String inputString) {
        String uppercase = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
        String lowercase = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = inputString.replaceAll("\\w", "");
        String allCharacter = inputString.replaceAll("\\W", "");
        System.out.println("Uppercase Character: " + uppercase);
        System.out.println("Lowercase Character: " + lowercase);
        System.out.println("Special Character: " + special);
        System.out.println("All Character: " + allCharacter);
    }

    public void analyzeString() {
        System.out.print("Input String: ");
        String s = sc.nextLine();
        getNumber(s);
        getCharacter(s);
    }
}
