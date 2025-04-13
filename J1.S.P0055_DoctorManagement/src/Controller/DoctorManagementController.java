/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Doctor;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author 84945
 */
public class DoctorManagementController {

    private HashMap<String, Doctor> doctorDatabase;
    Scanner sc = new Scanner(System.in);

    public DoctorManagementController() {
        this.doctorDatabase = new HashMap<String, Doctor>();
    }

    public void addDoctor() {
        String code = null;
        boolean validCode = false;
        while (!validCode) {
            System.out.print("Enter Code: ");
            try {
                code = sc.nextLine();
                if (!code.isEmpty()) {
                    validCode = true;
                } else {
                    System.err.println("Doctor Code is not null.");
                }
            } catch (Exception e) {
                System.err.println("Doctor Code is not null.");
                sc.nextLine();
            }
        }
        if (doctorDatabase.containsKey(code)) {
            System.err.println("Doctor code " + code + " is duplicate.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();
        int availability = 0;
        boolean validInt = false;
        while (!validInt) {
            System.out.print("Enter Availability: ");
            try {
                availability = sc.nextInt();
                validInt = true;
            } catch (Exception e) {
                System.err.println("Invalid input. Availability must be an integer.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctorDatabase.put(code, doctor);
        System.out.println("Successful.");
    }

    public void updateDoctor() {
        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        if (!doctorDatabase.containsKey(code)) {
            System.err.println("Doctor Code does not exist.");
            return;
        }
        Doctor doctor = doctorDatabase.get(code);

        System.out.println("Current Doctor Information:");
        System.out.println(doctor);

        System.out.println("Enter new information:");
        System.out.print("Enter Code: ");
        String newCode = sc.nextLine();
        doctor.setCode(newCode);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        doctor.setName(name);
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();
        doctor.setSpecialization(specialization);
        int availability = 0;
        boolean validInt = false;
        while (!validInt) {
            System.out.print("Enter Availability: ");
            try {
                availability = sc.nextInt();
                doctor.setAvailability(availability);
                validInt = true;
            } catch (Exception e) {
                System.err.println("Invalid input. Availability must be an integer.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.println("Updated successfully.");
    }

    public void deleteDoctor() {
        System.out.print("Enter Code: ");
        String code = sc.nextLine();
        if (!doctorDatabase.containsKey(code)) {
            System.out.println("Doctor code does not exist.");
            return;
        }
        doctorDatabase.remove(code);
        System.out.println("Delete successfully.");
    }

    public void searchDoctor() {
        System.out.print("Enter text: ");
        String keyword = sc.nextLine();
        System.out.println("-------- Results --------");
        for (Doctor doctor : doctorDatabase.values()) {
            if (doctor.toString().contains(keyword)) {
                System.out.println(doctor);
            }
//            } else if (doctorDatabase.values().isEmpty()) {
//                System.err.println("Data does not exist.");
//            }
        }
    }

//    public void viewD() {
//        for (Doctor doctor : doctorDatabase.values()) {
//            System.out.println(doctor.getCode() + ", " + doctor.getName() + ", " + doctor.getSpecialization() + ", " + doctor.getAvailability());
//        }
//
//    }
}
