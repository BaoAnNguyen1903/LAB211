package controller;

import java.util.Scanner;
import model.Parameter;
import model.Bmiparameter;
import view.Menu;

public class Programming extends Menu {

    Scanner sc = new Scanner(System.in);
    Validation valid = new Validation();
    Parameter param;
    Bmiparameter bmiParam;

    public Programming(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                normalCalculator();
                break;
            case 2:
                BMICalculator();
                break;
            case 3:
                System.exit(0);
        }
    }

    private String inputOperator() {
        System.out.print("Enter Operator: ");
        String operator = valid.checkInputOperator();
        return operator;
    }

    public void normalCalculator() {
    System.out.println("----- Normal Calculator -----");

    param = new Parameter();

    System.out.print("Enter number: ");
    double memory = valid.checkInputDouble();
    param.setMemory(memory);

    while (true) {
        String operator = inputOperator();

        if (operator.equalsIgnoreCase("=")) {
            System.out.println("Result: " + param.getMemory());
            return;
        }

        System.out.print("Enter number: ");
        double inputNumber = valid.checkInputDouble();

        switch (operator) {
            case "+":
                param.setMemory(param.getMemory() + inputNumber);
                break;
            case "-":
                param.setMemory(param.getMemory() - inputNumber);
                break;
            case "*":
                param.setMemory(param.getMemory() * inputNumber);
                break;
            case "/":
                if (inputNumber != 0) {
                    param.setMemory(param.getMemory() / inputNumber);
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            case "^":
                param.setMemory(Math.pow(param.getMemory(), inputNumber));
                break;
            default:
                System.out.println("Invalid operator. Please try again.");
                continue;
        }
        System.out.println("Memory: " + param.getMemory());
    }
}
    
    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    public void BMICalculator() {
        System.out.println("----- BMI Calculator -----");

        bmiParam = new Bmiparameter();

        System.out.print("Enter Weight(kg): ");
        bmiParam.setWeight(valid.checkInputDouble());
        System.out.print("Enter Height(cm): ");
        bmiParam.setHeight(valid.checkInputDouble());

        double bmi = bmiParam.getWeight() * 10000 / (bmiParam.getHeight() * bmiParam.getHeight());
        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}