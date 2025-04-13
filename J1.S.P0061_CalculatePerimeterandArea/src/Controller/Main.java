/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.CalculateView;

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
        String mChon[] = {"Calculate Shape",
            "Exit"};
        CalculateView calView = new CalculateView("\n=====Calculate Shape Program=====", mChon);
        calView.run();
    }
    
}
