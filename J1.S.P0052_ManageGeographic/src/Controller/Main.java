/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.GeographicListView;

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
        String mChon[] = {"Input the information of 11 countries in East Asia",
            "Display information of countries you’ve just input",
            "Search information of countries by user-entered name",
            "Display information of countries sorted name in ascending order",
            "Exit"};
        GeographicListView geoListView = new GeographicListView("============== MENU ==============", mChon);
        geoListView.run();
    }
    
}
