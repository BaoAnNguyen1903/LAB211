/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.FruitShopController;
import Model.Fruit;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84945
 */
public class FruitListView extends Menu<String> {

    FruitShopController fruitShopController = new FruitShopController();

    public FruitListView(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1:
                boolean cont = true;
                do {
                    try {
                        fruitShopController.addFruit();
                        System.out.println("Do you want to continue (Y/N)?");
                        String option = sc.nextLine();
                        if (option.equalsIgnoreCase("Y")) {
                            cont = true;
                        } else if (option.equalsIgnoreCase("N")) {
                            cont = false;
                        } else {
                            System.out.println("Please choose Y/N");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(FruitListView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FruitListView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } while (cont);
                break;
            case 2:
                fruitShopController.viewOrders();
                break;
            case 3:
                fruitShopController.shopping(sc);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
