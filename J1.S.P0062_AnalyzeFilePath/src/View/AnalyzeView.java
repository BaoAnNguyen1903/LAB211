/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AnalyzeFilePathController;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class AnalyzeView extends Menu<String> {
    Scanner sc = new Scanner(System.in);
    AnalyzeFilePathController analyzeController = new AnalyzeFilePathController();
    
    public AnalyzeView(String td, String[] mc) {
        super(td, mc);
    }
    
    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1:
                analyzeController.checkInputPath();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;
        }
    }
}
