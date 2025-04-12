/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EastAsiaCountryController;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class GeographicListView extends Menu<String> {

    EastAsiaCountryController countryController = new EastAsiaCountryController();

    public GeographicListView(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1:
                countryController.inputCountryInformation();
                break;
            case 2:
                countryController.displayCountryInformation();
                break;
            case 3:
                System.out.print("Enter country name to search: ");
                String countryName = sc.nextLine();
                countryController.searchCountryByName(countryName);
                break;
            case 4:
                countryController.displaySortedByCountryName();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
