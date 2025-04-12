/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Main;
import Controller.NormalizeTextController;
import Model.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84945
 */
public class NormalizeTextListView extends Menu<String> {

    File fileDemo = new File();
    NormalizeTextController nmTextController = new NormalizeTextController();

    public NormalizeTextListView(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1: {
                try {
                    nmTextController.readTextFile(fileDemo.getPathin());
                } catch (IOException ex) {
                    Logger.getLogger(NormalizeTextListView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2: {
                try {
                    nmTextController.NormalizeText();
                    nmTextController.readTextFile(fileDemo.getPathout());
                } catch (IOException ex) {
                    Logger.getLogger(NormalizeTextListView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
