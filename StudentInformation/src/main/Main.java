import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        
        System.out.println("====== Collection Sort Program ======");
        System.out.println("Enter student information");
        while (true) {
            Student student = new Student();

            System.out.print("Name: ");
            student.setName(scanner.nextLine());

            System.out.print("Mark: ");
            String markInput = scanner.nextLine();
            try {
                float mark = Float.parseFloat(markInput);
                student.setMark(mark);
            } catch (NumberFormatException e) {
                System.out.println("Invalid mark. Please enter a valid number.");
                continue;
            }

            System.out.print("Classes: ");
            student.setClasses(scanner.nextLine());

            students.add(student);

            System.out.print("Do you want to enter more student information? (Y/N): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        sortStudents(students);
        displayStudents(students);
    }

    public static List<Student> sortStudents(List<Student> students) {
        Collections.sort(students, new StudentComparator());
        return students;
    }

    public static void displayStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("-------------Student " + (i + 1) + "-------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Mark: " + student.getMark());
            System.out.println("Classes: " + student.getClasses());
        }
    }
}