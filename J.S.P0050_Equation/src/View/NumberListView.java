/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EquationController;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84945
 */
public class NumberListView extends Menu<String> {
    EquationController equationController = new EquationController();

    public NumberListView(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1:
                equationController.CalSuperlativeEquation();
                break;
            case 2:
                equationController.CalQuadraticEquation();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
