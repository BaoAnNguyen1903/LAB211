/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Country;
import Model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class EastAsiaCountryController {

    private List<Country> countries;

    public EastAsiaCountryController() {
        countries = new ArrayList<>();
    }
    Scanner sc = new Scanner(System.in);

    public void inputCountryInformation() {
        System.out.println("Enter code of country: ");
        String countryCode = sc.nextLine();
        System.out.println("Enter name of country: ");
        String countryName = sc.nextLine();
        float countryTotalArea = 0;
        boolean validFloat = false;
        while (!validFloat) {
            System.out.println("Enter total Area: ");
            try {
                countryTotalArea = sc.nextFloat();
                validFloat = true;
            } catch (Exception e) {
                System.err.println("Please input number.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.println("Enter terrain of country: ");
        String countryTerrain = sc.nextLine();
        EastAsiaCountries country = new EastAsiaCountries(countryCode, countryName, countryTotalArea, countryTerrain);
        countries.add(country);
    }
    
    public void displayCountryInformation() {
        System.out.println("ID      Name        Total Area      Terrain");
        for (Country country : countries) {
            country.display();
        }
    }
    
    public void searchCountryByName(String countryName) {
        for (Country country : countries) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
                return;
            }
        }
        System.out.println("Country not found!");
    }

    public void displaySortedByCountryName() {
        Collections.sort(countries, Comparator.comparing(Country::getCountryName));
        displayCountryInformation();
    }
}
