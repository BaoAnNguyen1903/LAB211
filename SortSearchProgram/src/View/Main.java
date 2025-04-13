package View;


import Controller.SearchController;
import Controller.SortAlgorithmController;
import java.util.Scanner;
import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

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
        Scanner sc = new Scanner(System.in);
        SortAlgorithmController sortController = new SortAlgorithmController();
        SearchController searchController = new SearchController();
        boolean cont = true;
        boolean cont1 = true;
        boolean cont2 = true;
        do {
            System.out.println("-----Sort-Search Program-----");
            System.out.println("1. Sort.");
            System.out.println("2. Search.");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //Sort
                    do {
                        System.out.println("1. Buddle Sort.");
                        System.out.println("2. Quick Sort.");
                        System.out.println("3. Exit");
                        int sortChoice = sc.nextInt();
                        switch (sortChoice) {
                            case 1:
                                sortController.BuddleSort();
                                break;
                            case 2:
                                sortController.QuickSort();
                                break;
                            case 3:
                                cont1 = false;
                                break;
                        }
                    } while (cont1);
                    break;
                case 2:
                    //Search
                    do {
                        System.out.println("1. Liner Search.");
                        System.out.println("2. Binary Seaerch.");
                        System.out.println("3. Exit");
                        int searchChoice = sc.nextInt();
                        switch (searchChoice) {
                            case 1:
                                searchController.LinerSearch();
                                break;
                            case 2:
                                searchController.BinarySearch();
                                break;
                            case 3:
                                cont2 = false;
                                break;
                        }
                    } while (cont2);
                    break;
                case 3:
                    System.out.println("Exit");
                    cont = false;
                    break;
            }
        } while (cont);
    }

}
