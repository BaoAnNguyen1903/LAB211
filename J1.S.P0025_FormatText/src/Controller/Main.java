package Controller;

import View.NormalizeTextListView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String mChon[] = {"Read File",
            "Normalize Content File",
            "Exit"};
        NormalizeTextListView fruitListView = new NormalizeTextListView("\nNORMALIZE CONTENT FILE", mChon);
        fruitListView.run();
    }

    
}
