/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class CalculateController {

    Scanner sc = new Scanner(System.in);
    
    public void CalculateShape(){
        Rectangle rectangle = inputRectangle();
        Circle circle = inputCircle();
        Triangle triangle = inputTriangle();
        display(triangle, rectangle, circle);
    }

    private Rectangle inputRectangle() {
        double width = 0;
        boolean validWidth = false;
        while (!validWidth) {
            System.out.println("Please input side width of Rectangle:");
            try {
                width = sc.nextDouble();
                if (width > 0) {
                    validWidth = true;
                } else {
                    System.err.println("Width must be greater than 0.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Width must be double.");
                sc.nextLine();
            }
        }
        double length = 0;
        boolean validLength = false;
        while (!validLength) {
            System.out.println("Please input length of Rectangle:");
            try {
                length = sc.nextDouble();
                if (length > 0) {
                    validLength = true;
                } else {
                    System.err.println("Length must be greater than 0.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Length must be double.");
                sc.nextLine();
            }
        }
        return new Rectangle(width, length);
    }

    private Circle inputCircle() {
        double radius = 0;
        boolean validRadius = false;
        while (!validRadius) {
            System.out.println("Please input radius of Circle:");
            try {
                radius = sc.nextDouble();
                if (radius > 0) {
                    validRadius = true;
                } else {
                    System.err.println("Radius must be greater than 0.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Radius must be double.");
                sc.nextLine();
            }
        }
        return new Circle(radius);
    }

    private Triangle inputTriangle() {
        while (true) {
            double sideA = 0;
            boolean validA = false;
            while (!validA) {
                System.out.println("Please input side A of Triangle:");
                try {
                    sideA = sc.nextDouble();
                    if (sideA > 0) {
                        validA = true;
                    } else {
                        System.err.println("Side must be greater than 0.");
                    }
                } catch (Exception e) {
                    System.err.println("Invalid input. Side must be double.");
                    sc.nextLine();
                }
            }
            double sideB = 0;
            boolean validB = false;
            while (!validB) {
                System.out.println("Please input side B of Triangle:");
                try {
                    sideB = sc.nextDouble();
                    if (sideB > 0) {
                        validB = true;
                    } else {
                        System.err.println("Side must be greater than 0.");
                    }
                } catch (Exception e) {
                    System.err.println("Invalid input. Side must be double.");
                    sc.nextLine();
                }
            }
            double sideC = 0;
            boolean validC = false;
            while (!validC) {
                System.out.println("Please input side C of Triangle:");
                try {
                    sideC = sc.nextDouble();
                    if (sideC > 0) {
                        validC = true;
                    } else {
                        System.err.println("Side must be greater than 0.");
                    }
                } catch (Exception e) {
                    System.err.println("Invalid input. Side must be double.");
                    sc.nextLine();
                }
            }
            if (sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
                return new Triangle(sideA, sideB, sideC);
            } else {
                System.err.println("Re-input!");
            }
        }
    }
    
    private void display(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
