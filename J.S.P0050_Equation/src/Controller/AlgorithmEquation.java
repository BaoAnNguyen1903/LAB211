/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84945
 */
public class AlgorithmEquation {
    public List<Float> calculateEquation(float a, float b) {
        List<Float> solutions = new ArrayList<>();

        if (a == 0) {
            if (b == 0) {
                // Infinite solutions
                return solutions;
            } else {
                // No solution
                return null;
            }
        }

        float x = -b / a;
        solutions.add(x);
        return solutions;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> solutions = new ArrayList<>();

        if (a == 0) {
            return calculateLinearEquation(b, c);
        }

        float discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            float x1 = (-b + (float) Math.sqrt(discriminant)) / (2 * a);
            float x2 = (-b - (float) Math.sqrt(discriminant)) / (2 * a);
            solutions.add(x1);
            solutions.add(x2);
        } else if (discriminant == 0) {
            float x = -b / (2 * a);
            solutions.add(x);
        }

        return solutions.isEmpty() ? null : solutions;
    }

    public static List<Float> calculateLinearEquation(float a, float b) {
        List<Float> solutions = new ArrayList<>();

        if (a == 0) {
            if (b == 0) {
                // Infinite solutions
                return solutions;
            } else {
                // No solution
                return null;
            }
        }
        float x = -b / a;
        solutions.add(x);
        return solutions;
    }

    public void displaySolutions(List<Float> solutions) {
        if (solutions == null) {
            System.out.println("No solution");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinite solutions");
        } else {
            System.out.print("Solutions: x = ");
            for (float solution : solutions) {
                System.out.print(" " + solution + " ");
            }
        }
        System.out.println("");
    }

    public void displayOddNumbers(float a, float b) {
        List<Float> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);

        System.out.print("Number is Odd: ");
        for (float number : numbers) {
            if (isOdd(number)) {
                System.out.println(number);
            }
        }
    }

    public void displayEvenNumbers(float a, float b) {
        List<Float> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);

        System.out.print("Number is Even: ");
        for (float number : numbers) {
            if (!isOdd(number)) {
                System.out.println(number);
            }
        }
    }

    public void displayPerfectSquareNumbers(float a, float b) {
        List<Float> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);

        System.out.print("Number is Perfect Square: ");
        for (float number : numbers) {
            if (isPerfectSquare(number)) {
                System.out.print(number);
            }
        }
    }
    
    public void displayOddNumbers(float a, float b, float c) {
        List<Float> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);

        System.out.print("Odd numbers(s): ");
        for (float number : numbers) {
            if (isOdd(number)) {
                System.out.print(" " + number + " ");
            }
        }
        System.out.println("");
    }

    public void displayEvenNumbers(float a, float b, float c) {
        List<Float> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);

        System.out.print("Number is Even: ");
        for (float number : numbers) {
            if (!isOdd(number)) {
                System.out.print(" " + number + " ");
            }
        }
        System.out.println("");
    }

    public void displayPerfectSquareNumbers(float a, float b, float c) {
        List<Float> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);

        System.out.print("Perfect square numbers:");
        for (float number : numbers) {
            if (isPerfectSquare(number)) {
                System.out.print(" " + number + " ");
            }
        }
    }
    
    public static boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public static boolean isPerfectSquare(float number) {
        float sqrt = (float) Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
}
