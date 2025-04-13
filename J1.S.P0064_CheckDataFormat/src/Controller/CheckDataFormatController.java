/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class CheckDataFormatController {
    
    Scanner sc = new Scanner(System.in);
    private ArrayList<Data> dataArrayList = new ArrayList<>();
    String PHONE_REGEX = "^0?[0-9]{9}$";
    String EMAIL_REGEX = "^[A-Za-z0-9%+_.-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}$";
    
    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }
    
    public String checkInputPhone() {
        while (true) {
            try {
                System.out.print("Phone number: ");
                int phoneCheck = Integer.parseInt(sc.nextLine());
                String resultCheck = String.valueOf(phoneCheck);
                if (!resultCheck.matches(PHONE_REGEX)) {
                    System.err.println("Phone number must be 10 digits");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Phone number must be number");
            }
        }
    }

    public String checkInputEmail() {
        while (true) {
            System.out.print("Email: ");
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_REGEX)) {
                System.err.println("Email must be correct format");
            } else {
                return emailCheck;
            }
        }
    }
    
    public String checkInputDate() {
        while (true) {
            try {
                System.out.print("Date: ");
                String dateCheck = checkInputString();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheck);
                return dateCheck;
            } catch (ParseException ex) {
                System.err.println("Date to correct format(dd/MM/yyyy)");
            }
        }
    }

    public void inputData(){
        String phone = checkInputPhone();
        String email = checkInputEmail();
        String date = checkInputDate();
        Data data = new Data(phone, email, date);
        dataArrayList.add(data);
        System.out.println("Input success!");
    }
}
