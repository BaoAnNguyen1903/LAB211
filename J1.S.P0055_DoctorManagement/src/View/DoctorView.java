/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DoctorManagementController;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class DoctorView extends Menu<String> {

    Scanner sc = new Scanner(System.in);
    DoctorManagementController doctorController = new DoctorManagementController();
    
    public DoctorView(String td, String[] mc) {
        super(td, mc);
    }
    
    @Override
    public void execute(int n) {
        Scanner sc = new Scanner(System.in);
        switch (n) {
            case 1:
                System.out.println("--------- Add Doctor ---------");
                doctorController.addDoctor();
                break;
            case 2:
                System.out.println("--------- Update Doctor ---------");
                doctorController.updateDoctor();
                //doctorController.viewD();
                break;
            case 3:
                System.out.println("--------- Delete Doctor ---------");
                doctorController.deleteDoctor();
                break;
            case 4:
                System.out.println("--------- Search Doctor ---------");
                doctorController.searchDoctor();
                //doctorController.viewD();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;
        }
    }
}
