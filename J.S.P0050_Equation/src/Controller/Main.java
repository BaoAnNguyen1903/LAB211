package Controller;

import View.NumberListView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 84945
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String mChon[] = {"Calculate Superlative Equation",
            "Calculate Quadratic Equation",
            "Exit"};
        NumberListView numberListView = new NumberListView("\n========= Equation Program =========", mChon);
        numberListView.run();
    }
    
}
