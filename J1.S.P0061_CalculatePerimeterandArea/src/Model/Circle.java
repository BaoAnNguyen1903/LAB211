/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DecimalFormat;

/**
 *
 * @author 84945
 */
public class Circle extends Shape {

    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI * radius * radius;
        String roundedPerimeter = decimalFormat.format(area);
        return Double.parseDouble(roundedPerimeter);
    }

    @Override
    public double getPerimeter() {
        double perimeter = Math.PI * 2 * radius;
        String roundedPerimeter = decimalFormat.format(perimeter);
        return Double.parseDouble(roundedPerimeter);
    }

    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
